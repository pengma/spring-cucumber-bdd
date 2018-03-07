package pres.seanan.help;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import pres.seanan.conf.ConfigType;

public class ConfigHelper {

    private static final Config BASE_CONFIG = ConfigFactory.load();
    private static final ObjectMapper MAPPER = buildObjectMapper();

    public static <T> T getConfig(ConfigType configType, Class<T> t) {
        return (T) MAPPER.convertValue(BASE_CONFIG.getConfig(BASE_CONFIG.getString(configType.getValue()))
                                               .withFallback(BASE_CONFIG)
                                               .root()
                                               .unwrapped(),
                                       t);
    }

    private static ObjectMapper buildObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

}
