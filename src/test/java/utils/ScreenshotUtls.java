package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtls {

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public static Path takeScreenshot(Page page, String name) {
        Path path = Paths.get("screenshots ",  name + ".png");
        page.screenshot(new Page.ScreenshotOptions().setPath(path));
        return path;
    }
}
