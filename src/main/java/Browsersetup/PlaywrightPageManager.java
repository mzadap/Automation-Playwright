package Browsersetup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import setup.ConfigLoader;

public class PlaywrightPageManager {

    static Browser browser1;
    static Page page;
    static Playwright playwright;
    public static Page browser_setup() {

        String browserName = ConfigLoader.getInstance().getBrowser();
        if (browserName == null) {
            //default browser
            playwright = Playwright.create();
            browser1 = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser1.newPage();
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            playwright = Playwright.create();
             browser1 = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             page = browser1.newPage();
            //browser1 = browser.newPage();
        } else {
            playwright = Playwright.create();
            browser1 = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser1.newPage();
        }
        return page;
         //Page page1 = browser1.newPage();
    }

    public static void closeBrowser() {
        browser1.close();
        page.close();
    }

    public void closePlaywright() {
        playwright.close();
    }

}
