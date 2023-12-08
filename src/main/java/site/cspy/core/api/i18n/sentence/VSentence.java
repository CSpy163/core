package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nVerb;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

/**
 *
 */
@Slf4j
public class VSentence implements I18nSentence {

    public static I18nSentence of(Class<? extends I18nVerb> verbClass, Boolean condition) {
        return Boolean.TRUE.equals(condition)? VSuccess.of(verbClass): VFail.of(verbClass);
    }

    @Override
    public String internationalize(Locale locale) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String code() {
        return "V_SENTENCE";
    }
}
