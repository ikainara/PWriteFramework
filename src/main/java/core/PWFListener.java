package core;

import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;

public class PWFListener extends BaseObject implements ITestListener {
    ITestContext iTestContext;

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        getLogger().error(String.format("Test '%s' is failed", iTestResult.getName()));
        try {
            var currentPage = (Page) iTestContext.getAttribute("page");
            Page.ScreenshotOptions options = new Page.ScreenshotOptions();
            Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir"), String.format("%s_%s.png", "testName", new Date().getTime()));
            options.setPath(path);
            currentPage.screenshot(options);
        } catch (Exception e) {
            getLogger().error(String.format("Error happens on saving screenshot: \n%s", e.getMessage()));
        }
    }

    private void makeScreenshot(String name) {

    }
}
