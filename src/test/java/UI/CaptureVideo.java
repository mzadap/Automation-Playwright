package UI;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import page.HomePage;

import java.nio.file.Paths;

public class CaptureVideo {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser1 = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser1.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./Records/")));
        Page page = context.newPage();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        page.navigate("https://automationexercise.com/");
        HomePage homePage = new HomePage(page);
        homePage.clickOnFirstProduct()
                .clickOnProducts()
                .clickOnCartButton();
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        context.close();
        page.close();
        playwright.close();
    }
}
