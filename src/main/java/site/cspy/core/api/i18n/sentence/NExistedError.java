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
public class NExistedError extends I18nError {
    private I18nNoun noun;


    public static NExistedError of(Class<? extends I18nNoun> nounClass) {
        try {
            return new NExistedError(nounClass.getDeclaredConstructor().newInstance());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException var3) {
            log.error("NExistedError of error: {}", var3.getMessage());
            return null;
        }
    }

    @Override
    public String code() {
        return "N_EXISTED_ERROR";
    }

    @Override
    public String internationalize(@NonNull Locale locale) {
        return switch (locale.getLanguage()) {
            case "en" -> "%s existed!".formatted(noun.internationalize(locale));
            default -> "%s已存在！".formatted(noun.internationalize(locale));
        };
    }
}
