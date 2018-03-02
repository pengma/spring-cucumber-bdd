package pres.seanan.help;

import lombok.Getter;
import pres.seanan.conf.ConfigInitiator;
import pres.seanan.conf.WebDriverConf;

public class ConfHelper {

    public final static WebDriverConf WEB_DRIVER_CONF = ConfigInitiator.getSingletonInstance();

    static boolean isFirefox(){
        return ConfigInitiator.getWebdriverName().contains("firefox");
    }
}
