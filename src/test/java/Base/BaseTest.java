package Base;

import Browsersetup.PlaywrightPageManager;
import com.microsoft.playwright.Page;
import io.qameta.allure.Epic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.PlaywrightListeners;

@Epic("UI Test")
public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected Page page;
    //ScreenshotHelper screenshotHelper;
    @BeforeMethod
    public void setUp() {
        page = PlaywrightPageManager.browser_setup();
        logger.info("browser initialization ");
      //  screenshotHelper = new ScreenshotHelper(page);
    }

    public Page getPage() {
        return page;
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

        }

        PlaywrightPageManager.closeBrowser();
        logger.info("tear down process");
    }
}
