package core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import configs.PWConfig;
import enums.PWFBrowserType;
import exceptions.PWFPlaywrightRunException;
import exceptions.PWFUnknownBrowserException;
import lombok.Getter;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;

public class PWriteObject extends BaseObject {
    private PWConfig pwConfig;
    private final PWFBrowserType pwfBrowserType;
    private Playwright playwright;
    @Getter
    private Browser browser;
    @Getter
    private BrowserContext browserContext;


    @SneakyThrows
    public PWriteObject(String browserName) {
        loadConfig();
        pwfBrowserType = PWFBrowserType.fromBrowserName(browserName);
        try {
            playwright = Playwright.create();
            BrowserType browserType = getBrowserType();
            browser = browserType.launch(getLaunchOption());
            Browser.NewContextOptions opt = new Browser.NewContextOptions();
            opt.setViewportSize(pwConfig.browserWidth(), pwConfig.browserHeight());
            browserContext = browser.newContext(opt);

        } catch (Exception e) {
            throw new PWFPlaywrightRunException(e.getMessage());
        }
    }

    private LaunchOptions getLaunchOption() {
        return new LaunchOptions()
                .setHeadless(pwConfig.isHeadless())
                .setSlowMo(50);
    }

    private void loadConfig() {
        if(pwConfig == null) {
            pwConfig = ConfigFactory.create(PWConfig.class);
        }
    }

    @SneakyThrows
    private BrowserType getBrowserType() {
        switch (pwfBrowserType.getBrowserName()) {
            case "chrome":
                return playwright.chromium();
            case "edge":
                return playwright.webkit();
            case "firefox":
                return playwright.firefox();
            default:
                throw new PWFUnknownBrowserException(String.format(
                        "Playwright is not configured to support browser: %s. Please add it to configuration",
                        pwfBrowserType.getBrowserName()));
        }
    }
}
