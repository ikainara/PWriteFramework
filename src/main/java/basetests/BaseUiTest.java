package basetests;

import core.BaseObject;
import core.PWFListener;
import core.PWriteObject;
import lombok.Getter;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(PWFListener.class)

@Getter
public class BaseUiTest extends BaseObject {
    private PWriteObject pWriteObject;

    public BaseUiTest() {
        pWriteObject = new PWriteObject("chrome");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext iTestContext) {
        iTestContext.setAttribute("driver", pWriteObject);
        getLogger().info(String.format("     ***** Start executing '%s' *****     ", this.getClass().getName()));
    }

    @AfterClass
    public void afterClass() {
        if (pWriteObject != null) {
            pWriteObject.getBrowserContext().close();
        }
    }
}
