package pres.seanan.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pres.seanan.conf.WebDriverConf;

import java.net.MalformedURLException;
import java.net.URL;

import static pres.seanan.conf.ConfigType.WEBDRIVER_CONFIG;


public class WebDriverHelper {

    private static final WebDriverConf WEB_DRIVER_CONF = ConfigHelper.getConfig(WEBDRIVER_CONFIG, WebDriverConf.class);
    public static WebDriver webDriver;

    private WebDriverHelper() {
    }

    public static void init() throws MalformedURLException {
        if (null == webDriver) {
            synchronized (WebDriverHelper.class) {
                if (null == webDriver) {
                    if (null != WEB_DRIVER_CONF.getBrowserPathName()) {
                        System.setProperty(WEB_DRIVER_CONF.getBrowserPathName(), WEB_DRIVER_CONF.getBrowserPath());
                    }
                    if (WEB_DRIVER_CONF.isRemote()) {
                        webDriver = new RemoteWebDriver(new URL(WEB_DRIVER_CONF.getRemoteUrl()), WEB_DRIVER_CONF.toDesiredCapabilities());
                    } else {
                        if (WEB_DRIVER_CONF.getBrowserName().equals("firefox")) {
                            webDriver = new FirefoxDriver();
                        } else if (WEB_DRIVER_CONF.getBrowserName().equals("chrome")) {
                            webDriver = new ChromeDriver();
                        } else if (WEB_DRIVER_CONF.getBrowserName().equals("phantomjs")) {
                            webDriver = new PhantomJSDriver();
                        }
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
