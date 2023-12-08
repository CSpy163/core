package site.cspy.core.api.i18n.verb;

import site.cspy.core.api.i18n.I18nVerb;
import lombok.NonNull;

import java.util.Locale;

public class VerbSave implements I18nVerb {

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "save";
            default -> "保存";
        };
    }

}
