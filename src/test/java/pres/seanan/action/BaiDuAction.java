package pres.seanan.action;

import org.springframework.beans.factory.annotation.Autowired;
import pres.seanan.annotation.Action;
import pres.seanan.page.BaiDuPage;

@Action
public class BaiDuAction {

    @Autowired
    BaiDuPage baiDuPage;

    public void getBaiDu() {
        baiDuPage.getBaiDu();
    }

    public void search(String content) {
        baiDuPage
                .inputSearchContent(content)
                .clickSearch();
    }

    public String getSource() {
        return baiDuPage.getPageSource();
    }

}
