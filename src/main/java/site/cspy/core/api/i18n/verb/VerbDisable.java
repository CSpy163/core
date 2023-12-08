package site.cspy.core.api.i18n.verb;

import site.cspy.core.api.i18n.I18nVerb;
import lombok.NonNull;

import java.util.Locale;

public class VerbDisable implements I18nVerb {
    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "disbale";
            default -> "禁用";
        };
    }
}
