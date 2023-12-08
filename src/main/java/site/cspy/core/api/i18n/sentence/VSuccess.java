package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nVerb;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/**
 *
 */
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class VSuccess implements I18nSentence {
    private I18nVerb verb;

    public static VSuccess of(Class<? extends I18nVerb> verbClass) {
        try {
            return new VSuccess(verbClass.getDeclaredConstructor().newInstance());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            log.error("VSuccess of error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String internationalize(Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s succeed.".formatted(verb.internationalize(locale));
            default -> "%s成功。".formatted(verb.internationalize(locale));
        };
    }


    @Override
    public String code() {
        return "V_SUCCESS";
    }
}
