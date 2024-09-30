package page;

import com.microsoft.playwright.Page;

public class ProductPage extends BasePage{

    /*public static ProductPage productPage() {
        return new ProductPage();
    }*/
   // private final Page page;

    public ProductPage(Page page) {
        super(page);
    }
    public ProductPage addProductToCart() {
        page.locator("(//a[contains(@class,'btn btn-default')])[5]").click();
        return this;
    }

    public CartsPage clickOnCartTab() {
        page.locator("//a[normalize-space()='Cart']").click();
        return new CartsPage(page);
    }

    public CartsPage clickOnCartButton1() {
        page.locator("//a[normalize-space()='Cart111']").click();
        return new CartsPage(page);
    }
}
