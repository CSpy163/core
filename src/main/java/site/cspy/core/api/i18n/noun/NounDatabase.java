package site.cspy.core.api.i18n.noun;

import site.cspy.core.api.i18n.I18nNoun;
import lombok.NonNull;

import java.util.Locale;

public class NounDatabase implements I18nNoun {

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "database";
            default -> "数据库";
        };
    }

}
