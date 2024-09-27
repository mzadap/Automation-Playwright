package page;

import com.microsoft.playwright.Page;

public class CartsPage {
    private final Page page;
    /*public static CartsPage cartsPage() {
        return new CartsPage();
    }*/

    public CartsPage(Page page) {
       // super(page);
        this.page = page;
    }
    //Page page;
    public CartsPage verifyProductsAdded() {
        page.locator("//table[@id='cart_info_table']/tbody/tr").count();
        return this;
    }

    public CartsPage verifyProductsAdded1() {
        page.locator("//table[@id='cart_info_table']/tbody/tr").count();
        return this;
    }
}
