package site.cspy.core.api.i18n.verb;

import site.cspy.core.api.i18n.I18nVerb;
import lombok.NonNull;

import java.util.Locale;

public class VerbReset implements I18nVerb {
    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "reset";
            default -> "重置";
        };
    }
}
