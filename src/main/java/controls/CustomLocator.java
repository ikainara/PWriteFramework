package controls;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public abstract class CustomLocator {
    private Page page;
    private Locator containerLocator;

    public CustomLocator(Locator containerLocator) {
        this.containerLocator = containerLocator;
        this.page = containerLocator.page();
    }
}
