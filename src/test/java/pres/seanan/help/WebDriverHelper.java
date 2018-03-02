package pres.seanan.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pres.seanan.conf.WebDriverConf;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverHelper {

    public static WebDriver webDriver;
    private static WebDriverConf webDriverConf;

    private WebDriverHelper() {
    }

    public static void init() throws MalformedURLException {
        if (null == webDriver) {
            synchronized (WebDriverHelper.class) {
                if (null == webDriver) {
                    webDriverConf = ConfHelper.WEB_DRIVER_CONF;
                    if (ConfHelper.isFirefox()) {
                        System.setProperty("webdriver.gecko.driver", webDriverConf.getBrowserPath());
                    }
                    if (webDriverConf.isRemote()) {
                        webDriver = new RemoteWebDriver(new URL(webDriverConf.getRemoteUrl()), webDriverConf.toDesiredCapabilities());
                    } else {
                        webDriver = new FirefoxDriver();
                    }
                }
            }
        }
    }

    public static void destroy() {
        if (null != webDriver) {
            synchronized (webDriver) {
                if (null != webDriver) {
                    webDriver.close();
                    webDriver = null;
                }
            }
        }
    }

}
