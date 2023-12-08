package site.cspy.core.api.i18n.sentence;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

@Slf4j
public class NotLoginError extends I18nError {

    @Override
    public String code() {
        return "NOT_LOGIN_ERROR";
    }

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "Not Login!";
            default -> "未登录！";
        };
    }
}
