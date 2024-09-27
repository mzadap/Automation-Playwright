package utils;

import Base.BaseTest;
import Base.BaseTestRest;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlaywrightListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
       Object object = result.getInstance();
       Page page = ((BaseTest) object).getPage();
       Path screenshotPath = ScreenshotUtls.takeScreenshot(page, result.getName());
       try {
           Allure.addAttachment("Screenshot", new ByteArrayInputStream(Files.readAllBytes(screenshotPath)));
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
