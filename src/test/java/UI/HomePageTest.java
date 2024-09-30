package UI;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import utils.PlaywrightListeners;

@Listeners(PlaywrightListeners.class)
public class HomePageTest extends BaseTest {


    /*
    * A sample application to testing UI functionality."
    * */

    Logger logger = LoggerFactory.getLogger(HomePageTest.class);

    @Test(description = "Verify if product is added successfully to cart")
    @Step("Verify Flow to add product to cart")
    public void test_product_added_to_cart() {
        HomePage homePage = new HomePage(page);
        homePage.goToUrl()
                .clickOnFirstProduct()
                .verifyProductsAddedToCartMessage("Your product has been added to cart.", "Your product has been added to cart.")
                .clickOnProductsTabs()
                .addProductToCart()
                .clickOnCartTab()
                .verifyProductsIsAddedToCart()
                .clickOnCheckoutButton()
                .verifyCheckoutMessage("Checkout");
        logger.info("test completed");
    }

    @Test(description = "Verify test for invalid message while adding product to cart", priority = 1)
    @Step("Check validation message")
    public void add_item_to_cart() {
        HomePage homePage = new HomePage(page);
        homePage.goToUrl()
                .clickOnFirstProduct()
                .verifyProductsAddedToCartMessage("Your product has been added to cart.", "Your product has been added to cart 10000.");
        logger.info("test completed");
    }
}
