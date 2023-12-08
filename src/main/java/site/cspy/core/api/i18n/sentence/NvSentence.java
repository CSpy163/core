package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nNoun;
import site.cspy.core.api.i18n.I18nVerb;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

/**
 *
 */
@Slf4j
public class NvSentence implements I18nSentence {

    public static I18nSentence of(Class<? extends I18nNoun> nounClass, Class<? extends I18nVerb> verbClass, Boolean condition) {
        return Boolean.TRUE.equals(condition) ? NvSuccess.of(nounClass, verbClass) : NvFail.of(nounClass, verbClass);
    }

    @Override
    public String internationalize(Locale locale) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String code() {
        return "NV_SENTENCE";
    }
}
