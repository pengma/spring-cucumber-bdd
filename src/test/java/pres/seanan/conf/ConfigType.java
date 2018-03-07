package pres.seanan.conf;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigType {

    WEBDRIVER_CONFIG("webDriver.name"),
    ENVIRONMENT_CONFIG("environment.name");

    private String value;

}
