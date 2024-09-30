package page;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class HomePage extends BasePage{

    static final Logger logger = LoggerFactory.getLogger(HomePage.class.getName());

    public HomePage(Page page) {
        super(page);
    }

    private final String productButton = "(//a[contains(@class,'btn btn-default')])[1]";


    public HomePage clickOnFirstProduct() {
        page.locator(productButton).click();
        return this;
    }

    //Navigate to another Page class object from Home Page
    public ProductPage clickOnProductsTabs() {
        page.locator("//a[@href='/products']").click();
        return new ProductPage(page);
    }

    public HomePage verifyProductsAddedToCartMessage(String name, String expectedMessage) {
        try{
            findDynamicLocator("//p[normalize-space()='%s']", name).isVisible();
            logger.info(findDynamicLocator("//p[normalize-space()='%s']", name).textContent());
            Assert.assertEquals(findDynamicLocator("//p[normalize-space()='%s']", name).textContent(), expectedMessage);
        } catch (Exception e) {
            logger.error("Assertion failed");
        }
        page.locator("//button[normalize-space()='Continue Shopping']").click();
        return this;
    }

    public HomePage goToUrl() {
        page.navigate("https://automationexercise.com/");
        return this;
    }
}
