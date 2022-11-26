package enums;

import exceptions.PWFUnknownBrowserException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum PWFBrowserType {
    CHROME("chromium", "chrome"),
    FIREFOX("firefox", "firefox"),
    EDGE("webkit", "edge");

    private final String pwBrowserName;
    private final String browserName;

    @SneakyThrows
    public static PWFBrowserType fromBrowserName(String browserName) {
        Optional<PWFBrowserType> browser = Arrays.stream(values()).filter(v -> v.getBrowserName().equalsIgnoreCase(browserName)).findFirst();
        if(browser.isPresent()) {
            return browser.get();
        } else {
            throw new PWFUnknownBrowserException(String.format("Unknown browser: %s", browserName));
        }
    }
}
