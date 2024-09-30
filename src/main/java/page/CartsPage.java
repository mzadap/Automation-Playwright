package page;

import com.microsoft.playwright.Page;
import org.testng.Assert;

public class CartsPage {
    private final Page page;

    public CartsPage(Page page) {
        this.page = page;
    }

    public CartsPage verifyProductsIsAddedToCart() {
        page.locator("//table[@id='cart_info_table']/tbody/tr").count();
        return this;
    }

    public CartsPage verifyProductsAdded1() {
        page.locator("//table[@id='cart_info_table']/tbody/tr").count();
        return this;
    }

    public CartsPage clickOnCheckoutButton() {
        page.locator("//a[contains(@class,'btn btn-default')]").click();
        return this;
    }

    public CartsPage verifyCheckoutMessage(String expectdMessage) {
        Assert.assertEquals(page.locator("//h4[normalize-space(text())='Checkout']").textContent(), expectdMessage);
        return this;
    }
}
