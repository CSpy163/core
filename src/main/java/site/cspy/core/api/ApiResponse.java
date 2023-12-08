package site.cspy.core.api;

import site.cspy.core.api.i18n.sentence.I18nError;
import site.cspy.core.api.i18n.sentence.I18nSentence;
import site.cspy.core.api.i18n.sentence.I18nSuccess;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.server.ServerWebExchange;

import java.util.Locale;
import java.util.Optional;

@Data
@JsonIgnoreProperties({"sentence"})
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    private I18nSentence sentence;

    public ApiResponse(T data, I18nSentence sentence) {
        this.data = data;
        this.sentence = Optional.ofNullable(sentence).orElse(new I18nError());
        // 预设默认值
        this.message = this.sentence.internationalize(ApiContextHolder.DEFAULT_LOCALE);
        this.code = this.sentence.code();
    }

    public static <T> ApiResponse<T> wrap(T data, I18nSentence sentence) {
        return new ApiResponse<>(data, sentence);
    }

    public static <T> ApiResponse<T> sentence(I18nSentence sentence) {
        return new ApiResponse<>(null, sentence);
    }

    public static <T> ApiResponse<T> data(T data) {
        return data == null ? new ApiResponse<>(null, new I18nError()) : new ApiResponse<>(data, new I18nSuccess());
    }

    public static <U> ApiResponse<U> sentence(Class<? extends I18nSentence> sentenceClass) {
        try {
            return new ApiResponse<>(null, sentenceClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return new ApiResponse<>(null, new I18nError());
        }
    }

    public ApiResponse<T> with(Locale locale) {
        this.setMessage(sentence.internationalize(Optional.ofNullable(locale).orElse(ApiContextHolder.DEFAULT_LOCALE)));
        return this;
    }

    public ApiResponse<T> with(ServerWebExchange webExchange) {
        return webExchange == null ? this : with(webExchange.getLocaleContext().getLocale());
    }


}
