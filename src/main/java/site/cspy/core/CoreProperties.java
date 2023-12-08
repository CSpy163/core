package site.cspy.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Data
@ConfigurationProperties(prefix = "core")
public class CoreProperties {
    private Locale defaultLocale;
}
