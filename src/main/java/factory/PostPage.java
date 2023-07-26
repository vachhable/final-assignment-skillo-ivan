package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostPage {
        public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/create";
        private final WebDriver driver;
        public PostPage(WebDriver driver) {
            this.driver = driver;
        }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(PostPage.PAGE_URL));
    }
}
