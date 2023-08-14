package finalAssignment;

import object.HomePage;
import object.UserPage;
import object.PostPage;
import object.Header;
import object.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends TestObject {
    @DataProvider(name = "getUsers")
    public Object [][] getUsers() {
        return new Object[][]{{"IvanPenchev2", "IvanPenchev123"}

        };
    }
    @Test (dataProvider = "getUsers")
    public void testSearchFieldFromHomeAsLoggedInUser(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isUrlLoaded(), "The Homepage URL is not correct!");
        Header header = new Header(getDriver());
        header.clickAndPopulateSearchField();
        header.searchDropdownAndUserClick();

        UserPage userPage = new UserPage(getDriver());
        userPage.isUrlLoaded();
    }
    @Test(dataProvider = "getUsers", priority = 1)
    public void testSearchFieldFromProfileAsLoggedInUser(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isUrlLoaded(), "The Homepage URL is not correct!");

        Header header = new Header(getDriver());
        header.clickProfile();

        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUrlLoaded(), "The User page URL is not correct!");
        header.clickAndPopulateSearchField();
        header.searchDropdownAndUserClick();
        userPage.isUrlLoaded();

    }

    @Test(dataProvider = "getUsers", priority = 2)
    public void testSearchFieldFromPostPageAsLoggedInUser(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isUrlLoaded(), "The Homepage URL is not correct!");

        Header header = new Header(getDriver());
        header.clickNewPost();

        PostPage postPage = new PostPage(getDriver());
        Assert.assertTrue(postPage.isUrlLoaded(), "The Post page URL is not correct!");

        header.clickAndPopulateSearchField();
        header.searchDropdownAndUserClick();

        UserPage userPage = new UserPage(getDriver());
        userPage.isUrlLoaded();

    }
    @Test (priority = 3)
    public void testSearchFieldFromHomeAsAnonymousUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        Assert.assertFalse(header.isSearchFieldVisible(), "Search field is visible as anonymous!");
    }

    @Test (dataProvider = "getUsers", priority = 4)
    public void testSearchFieldAsLoggedInUserWithStrangeSymbols(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(username);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isUrlLoaded(), "The Homepage URL is not correct!");

        Header header = new Header(getDriver());
        header.clickNewPost();

        PostPage postPage = new PostPage(getDriver());
        Assert.assertTrue(postPage.isUrlLoaded());
        header.searchFieldWithStrangeSymbols();

        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUrlLoaded(), "The User Page URL is not correct!");
    }

}
