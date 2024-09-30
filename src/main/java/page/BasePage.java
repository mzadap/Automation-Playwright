package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage  {

   Page page;
   public BasePage(Page page) {
       this.page = page;
   }

   public Locator findDynamicLocator(String locatorTemp, String name) {
       String locator = String.format(locatorTemp, name);
       return page.locator(locator);
   }
}
