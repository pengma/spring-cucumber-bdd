package pres.seanan.conf;

import lombok.Data;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

@Data
public class WebDriverConf {

    private String browserName;
    private String version;
    private String platform;
    private String browserPathName;
    private String browserPath;
    private String remoteUrl;

    public boolean isRemote() {
        return null != remoteUrl;
    }

    public DesiredCapabilities toDesiredCapabilities() {
        return new DesiredCapabilities(browserName, version, Platform.valueOf(platform));
    }
}
