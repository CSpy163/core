package site.cspy.core.api;

import site.cspy.core.CoreProperties;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ApiContextHolder implements ApplicationContextAware {

    public static Locale DEFAULT_LOCALE = Locale.CHINA;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CoreProperties bean = applicationContext.getBean(CoreProperties.class);
        DEFAULT_LOCALE = bean.getDefaultLocale();
    }
}
