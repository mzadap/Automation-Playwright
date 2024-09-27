package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage  {

   Page page;
   public BasePage(Page page) {
       this.page = page;
       //this.page = PlaywrightBaseTest.browser_setup();
   }



   public Locator getLocatorDynmically(String locatorTemp, String name) {
       String locator = String.format(locatorTemp, name);
       System.out.println(locator);
       return page.locator(locator);
   }
}
