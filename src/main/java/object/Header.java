package object;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement postLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-new-post")));
        postLink.click();
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();
    }
    public void clickAndPopulateSearchField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-bar")));
        searchField.click();
        searchField.sendKeys("IvanPenchevSkillo");
    }

    public void searchDropdownAndUserClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement userNameInDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'IvanPenchevSkillo')]")));
        userNameInDropdown.click();
    }

    public boolean isSearchFieldVisible(){
        try{
            WebElement searchField = driver.findElement(By.id("search-bar"));
            return searchField.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void searchFieldWithStrangeSymbols(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-bar")));
        searchField.click();
        searchField.sendKeys("@sdfsd.com");
        WebElement userNameInDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'fdasdf@sdfsd.com')]")));
        userNameInDropdown.click();
    }

}
