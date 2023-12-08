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
public class VFail implements I18nSentence {
    private I18nVerb verb;

    public static VFail of(Class<? extends I18nVerb> verbClass) {
        try {
            return new VFail(verbClass.getDeclaredConstructor().newInstance());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            log.error("VFail of error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String internationalize(Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s failed!".formatted(verb.internationalize(locale));
            default -> "%s失败！".formatted(verb.internationalize(locale));
        };
    }


    @Override
    public String code() {
        return "V_FAIL";
    }
}
