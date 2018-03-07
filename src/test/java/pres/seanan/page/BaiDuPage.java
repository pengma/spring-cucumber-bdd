package pres.seanan.page;

import org.openqa.selenium.By;
import pres.seanan.annotation.Page;

import static pres.seanan.help.WebDriverHelper.webDriver;

@Page
public class BaiDuPage {

    public BaiDuPage inputSearchContent(String content) {
        webDriver.findElement(Bys.SEARCH_CONTENT_INPUT).sendKeys(content);
        return this;
    }

    public void getBaiDu(String url) {
        webDriver.navigate().to(url);
    }

    public void clickSearch() {
        webDriver.findElement(Bys.SEARCH_BUTTON).click();
    }

    public String getPageSource() {
        return webDriver.getPageSource();
    }

    private interface Bys {

        By SEARCH_CONTENT_INPUT = By.id("kw");
        By SEARCH_BUTTON = By.id("su");

    }

}
