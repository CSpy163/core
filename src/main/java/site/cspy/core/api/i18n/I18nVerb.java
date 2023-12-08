package site.cspy.core.api.i18n;

public interface I18nVerb extends I18nObject {

    @Override
    default I18nType type() {
        return I18nType.VERB;
    }

}
