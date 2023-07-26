package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    @FindBy(id = "nav-link-new-post")
    private WebElement postLink;
    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;
    @FindBy(id = "search-bar")
    private WebElement searchField;
    @FindBy(xpath = "//*[contains(text(),'IvanPenchevSkillo')]")
    private WebElement userNameInDropdown;

    @FindBy(xpath = "//*[contains(text(),'fdasdf@sdfsd.com')]")
    private WebElement specialSymbolsInDropdown;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(postLink));
        postLink.click();
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }
    public void clickAndPopulateSearchField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable((searchField)));
        searchField.click();
        searchField.sendKeys("IvanPenchevSkillo");
    }

    public void searchDropdownAndUserClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.elementToBeClickable(userNameInDropdown));
        userNameInDropdown.click();
    }

    public boolean isSearchFieldVisible() {
        try {
            return searchField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void searchFieldWithStrangeSymbols(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click();
        searchField.sendKeys("@sdfsd.com");
        wait.until(ExpectedConditions.elementToBeClickable(specialSymbolsInDropdown));
        specialSymbolsInDropdown.click();
    }

}
