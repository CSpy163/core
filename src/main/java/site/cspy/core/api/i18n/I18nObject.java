package site.cspy.core.api.i18n;

import lombok.NonNull;

import java.util.Locale;

/**
 * 用于标记 I18n 中的对象
 * 具有：code、message 属性
 */
public interface I18nObject {

    /**
     * I18N 对象的类型
     */
    enum I18nType {
        OBJECT, VERB, NOUN, SENTENCE;
    }

    /**
     * I18N 对象类型
     *
     * @return I18N 对象类型
     */
    I18nType type();

    /**
     * 获取规定语言下的输出
     *
     * @param locale 语言
     * @return 输出
     */
    String internationalize(@NonNull Locale locale);
}
