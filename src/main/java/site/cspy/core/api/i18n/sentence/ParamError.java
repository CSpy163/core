package site.cspy.core.api.i18n.sentence;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

@Slf4j
public class ParamError extends I18nError {
    private String[] args = new String[0];

    public ParamError() {
    }


    public ParamError(String... args) {
        this.args = args;
    }

    public static ParamError of(String... args) {
        return new ParamError(args);
    }

    @Override
    public String code() {
        return "PARAM_ERROR";
    }

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s error!".formatted(String.join(", ", args));
            default -> "%s 字段错误！".formatted(String.join("、 ", args));
        };
    }
}
