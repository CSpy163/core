package site.cspy.core.api.i18n.noun;

import site.cspy.core.api.i18n.I18nNoun;
import lombok.NonNull;

import java.util.Locale;

public class NounParam implements I18nNoun {

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "parameter";
            default -> "参数";
        };
    }

}
