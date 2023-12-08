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
public class NNotExistedError extends I18nError {
    private I18nNoun noun;


    public static I18nError of(Class<? extends I18nNoun> nounClass) {
        try {
            return new NNotExistedError(nounClass.getDeclaredConstructor().newInstance());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException var3) {
            log.error("NNotExistedError of error: {}", var3.getMessage());
            return new I18nError();
        }
    }

    @Override
    public String code() {
        return "N_NOT_EXISTED_ERROR";
    }

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s not existed!".formatted(noun.internationalize(locale));
            default -> "%s不存在！".formatted(noun.internationalize(locale));
        };
    }
}
