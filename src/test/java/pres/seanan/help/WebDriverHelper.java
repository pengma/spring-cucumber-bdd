package pres.seanan.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pres.seanan.conf.ConfigInitiator;
import pres.seanan.conf.WebDriverConf;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverHelper {

    public static WebDriver webDriver;

    private WebDriverHelper() {
    }

    public static void init() throws MalformedURLException {
        if (null == webDriver) {
            synchronized (WebDriverHelper.class) {
                if (null == webDriver) {
                    WebDriverConf webDriverConf = ConfigInitiator.getSingletonInstance();
                    if (null != webDriverConf.getBrowserPathName()) {
                        System.setProperty(webDriverConf.getBrowserName(), webDriverConf.getBrowserPath());
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
