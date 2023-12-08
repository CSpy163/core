package site.cspy.core.api.i18n.sentence;

import site.cspy.core.api.i18n.I18nObject;

/**
 * 操作逻辑父类，可继承并实现自定义操作。
 * operateCode 用于作为响应中的 code 字段，用于前端判断操作是否成功。
 */
public interface I18nSentence extends I18nObject {

    String code();

    @Override
    default I18nType type() {
        return I18nType.SENTENCE;
    }

}
