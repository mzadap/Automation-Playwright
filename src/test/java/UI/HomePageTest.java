package UI;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import setup.ConfigLoader;
import utils.PlaywrightListeners;

@Listeners(PlaywrightListeners.class)
public class HomePageTest extends BaseTest {

    Logger logger = LoggerFactory.getLogger(HomePageTest.class);
    //@Test(description = "End to End test")
    @Step("")
    public void test2() {
        String url = ConfigLoader.getInstance().getUrl();
        HomePage homePage = new HomePage(page);
        System.out.println("url " + url);
        homePage.goToUrl().clickOnFirstProduct()
                .verifyProductsAddedToCartMessage("Your product has been added to cart. 1000")
                .clickOnProducts()
                .addProduct()
                .clickOnCartButton()
                .verifyProductsAdded();
        logger.info("test completed");
    }

    @Test(description = "Add item to cart")
    @Step("End to End test 2 ")
    public void add_item_to_cart() {
        String url = ConfigLoader.getInstance().getUrl();
        HomePage homePage = new HomePage(page);
        homePage.goToUrl()
                .clickOnFirstProduct()
                .verifyProductsAddedToCartMessage("Your product has been added to cart")
                .clickOnProducts()
                .addProduct()
                .clickOnCartButton1()
                .verifyProductsAdded();
        logger.info("test completed");
    }
}
