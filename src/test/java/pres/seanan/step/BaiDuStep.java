package pres.seanan.step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.zh_cn.当;
import org.springframework.beans.factory.annotation.Autowired;
import pres.seanan.action.BaiDuAction;
import pres.seanan.help.WebDriverHelper;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class BaiDuStep extends AbstractSteps {

    @Autowired
    BaiDuAction baiDuAction;

    @当("^打开 BaiDu 搜索$")
    public void openBaiDu() {
        baiDuAction.getBaiDu(ENVIRONMENT_CONF.getBaseUrl());
    }

    @当("^输入 \"([^\"]*)\" 在搜索框, 点击搜索$")
    public void search(String content) throws Throwable {
        baiDuAction.search(content);
    }

    @当("^将搜索到 \"([^\"]*)\" 相关信息$")
    public void assertMessage(String message) throws Throwable {
        assertThat(baiDuAction.getSource()).contains(message);
    }

    @Before
    public void beforeScenario() throws MalformedURLException {
        WebDriverHelper.init();
    }

    @After
    public void afterScenario() {
        WebDriverHelper.destroy();
    }
}
