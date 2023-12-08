package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nNoun;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class NError extends I18nError {
    private I18nNoun noun;


    public static I18nError of(Class<? extends I18nNoun> nounClass) {
        try {
            return new NError(nounClass.getDeclaredConstructor().newInstance());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException var3) {
            log.error("NError of error: {}", var3.getMessage());
            return new I18nError();
        }
    }

    @Override
    public String code() {
        return "N_ERROR";
    }

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s error.".formatted(noun.internationalize(locale));
            default -> "%s错误。".formatted(noun.internationalize(locale));
        };
    }
}
