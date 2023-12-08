package site.cspy.core.api.i18n.sentence;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;


@Slf4j
public class I18nSuccess implements I18nSentence {

    @Override
    public String internationalize(Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "Operate success.";
            default -> "操作成功。";
        };
    }


    @Override
    public String code() {
        return "SUCCESS";
    }
}
