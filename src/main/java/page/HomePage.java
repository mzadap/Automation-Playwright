package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.IClass;
import setup.ConfigLoader;

import java.nio.file.Paths;

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

    public ProductPage clickOnProducts() {
        page.locator("//a[@href='/products']").click();
        return new ProductPage(page);
    }

    public HomePage verifyProductsAddedToCartMessage(String name) {
        //Locator message = getLocatorDynmically("\"//p[normalize-space()='%s']\"", name);
        try{
            getLocatorDynmically("//p[normalize-space()='%s']", name).isVisible();
            logger.info(getLocatorDynmically("//p[normalize-space()='%s']", name).textContent());
            Assert.assertEquals(getLocatorDynmically("//p[normalize-space()='%s']", name).textContent(), "Your product has been added to cart to perfect 10.");

        } catch (Exception e) {
            logger.error("Assertion failed");
        }

        //page.locator("//p[normalize-space()='Your product has been added to cart.']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./screenshot/Element.png")));
        page.locator("//button[normalize-space()='Continue Shopping']").click();
        return this;
    }

    public HomePage goToUrl() {
       page.navigate("https://automationexercise.com/");
        return this;
    }
   /* public HomePage takeScreenshot() {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/Homepage.png")));
        return this;
    }*/

    /*public void getRadioButton() {
        //page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        page.locator("(//input[@name='radioButton'])[1]").click();
    }*/

}
