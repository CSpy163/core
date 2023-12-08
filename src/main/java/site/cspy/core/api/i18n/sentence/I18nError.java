package site.cspy.core.api.i18n.sentence;

import lombok.NonNull;

import java.util.Locale;

public class I18nError extends RuntimeException implements I18nSentence {
    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "unknown error!";
            default -> "未知错误！";
        };
    }

    @Override
    public String code() {
        return "UNKNOWN_ERROR";
    }
}
