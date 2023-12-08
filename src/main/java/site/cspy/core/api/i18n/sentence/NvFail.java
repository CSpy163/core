package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nNoun;
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
public class NvFail implements I18nSentence {
    private I18nNoun noun;
    private I18nVerb verb;

    public static NvFail of(Class<? extends I18nNoun> nounClass, Class<? extends I18nVerb> verbClass) {
        try {
            return new NvFail(nounClass.getDeclaredConstructor().newInstance(), verbClass.getDeclaredConstructor().newInstance());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            log.error("NvFail of error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String internationalize(Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s %s failed!".formatted(noun.internationalize(locale), verb.internationalize(locale));
            default -> "%s%s失败！".formatted(noun.internationalize(locale), verb.internationalize(locale));
        };
    }


    @Override
    public String code() {
        return "NV_FAIL";
    }
}
