package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nNoun;
import site.cspy.core.api.i18n.I18nVerb;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class NvError extends I18nError {
    private I18nNoun noun;
    private I18nVerb verb;


    public static I18nError of(Class<? extends I18nNoun> nounClass, Class<? extends I18nVerb> verbClass) {
        try {
            return new NvError(nounClass.getDeclaredConstructor().newInstance(), verbClass.getDeclaredConstructor().newInstance());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException var3) {
            log.error("NvError of error: {}", var3.getMessage());
            return new I18nError();
        }
    }

    @Override
    public String code() {
        return "Nv_ERROR";
    }

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s %s error.".formatted(noun.internationalize(locale), verb.internationalize(locale));
            default -> "%s %s 错误。".formatted(noun.internationalize(locale), verb.internationalize(locale));
        };
    }
}
