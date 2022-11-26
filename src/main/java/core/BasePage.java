package core;

import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public abstract class BasePage extends BaseObject {
    protected Page page;
    public BasePage(Page page) {
        this.page = page;
    }
}
