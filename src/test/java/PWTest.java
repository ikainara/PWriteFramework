import basetests.BaseUiTest;
import com.microsoft.playwright.Page;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class PWTest extends BaseUiTest {
    @Test
    @SneakyThrows
    public void test() {
        Page page =  getPWriteObject().getBrowserContext().newPage();
        page.navigate("http://www.google.com");
    }
}
