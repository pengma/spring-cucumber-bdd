package pres.seanan.conf;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Map;

public class ConfigInitiator {

    private static final String WEBDRIVER_NAME = "webDriver.name";
    private static final Config BASE_CONFIG = ConfigFactory.load();
    private static final ObjectMapper MAPPER = buildObjectMapper();
    private static final Config ENVIRONMENT_CONFIG = loadConfigForEnvironment(getWebdriverName());
    private static final WebDriverConf TEST_CONF = buildTestConfSingleton(ENVIRONMENT_CONFIG);

    public static WebDriverConf getSingletonInstance() {
        return TEST_CONF;
    }

    public static String getWebdriverName() {
        return BASE_CONFIG.getString(WEBDRIVER_NAME);
    }

    private static Config loadConfigForEnvironment(String environmentName) {
        return BASE_CONFIG.getConfig(environmentName).withFallback(BASE_CONFIG);
    }

    private static ObjectMapper buildObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    private static WebDriverConf buildTestConfSingleton(Config environmentConfig) {
        Map<String, Object> unwrappedConfig = environmentConfig.root().unwrapped();
        return MAPPER.convertValue(unwrappedConfig, WebDriverConf.class);
    }

}


