import site.cspy.core.CoreApplication;
import site.cspy.core.CoreProperties;
import site.cspy.core.api.ApiResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = CoreApplication.class)
public class CoreTest {

    @Resource
    CoreProperties coreProperties;

    @Test
    public void test() {
        log.info("coreProperties: {}", coreProperties);
    }

    @Test
    public void testLocale() {
        log.info(ApiResponse.data("empty string").toString());
    }
}
