package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.NykaaSearchTest;
import utils.*;

public class StepDefinitions {
    private WebDriver driver;
    NykaaSearchTest nykaaSearchTest;
    String url;
    HashMap<String, String> data;
    Scenario scenario;

    public StepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(
            order = 1
    )
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("the user navigates to the home page")
    public void theUserNavigateToHomePage() {
        this.url = QaProps.getValue("url");
        this.driver.get(this.url);
        this.data = TestDataReader.getData(this.scenario.getName());
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
    }

    @When("the user can able to click on search bar")
    public void theUserCanAbleToClickOnSearchBar() {
        ClickUtils.click(driver,this.nykaaSearchTest.getSearchBar());
       // this.nykaaSearchTest.getSearchBar().click();
    }

    @Then("the drop down appear")
    public void theDropDownAppear()  {
        WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getDropDown());
        Assert.assertTrue(this.nykaaSearchTest.getDropDown().isDisplayed());

    }

    @And("the user enter the product name")
    public void the_user_enter_the_product_name() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(this.data.get("Input"));
        this.nykaaSearchTest.getSearchBar().sendKeys(Keys.ENTER);
    }

    @Then("the product results should be displayed")
    public void theProductResultsShouldBeDisplayed(){
        WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getSearchBarPage());
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }

    @When("the user enter the product name in marathi")
    public void theUserEnterTheProductNameInMarathi() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(this.data.get("Input"));
        WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getSearchBar());
    }

    @And("The user is able to click on enter key")
    public void theUserIsAbleToClickOnEnterKey() throws InterruptedException {
        this.nykaaSearchTest.getSearchBar().sendKeys(Keys.ENTER);
        WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getSearchedPage());
    }

    @Then("the sorry message will be displayed")
    public void theSorryMessageWillBeDisplayed() {
        String text = this.nykaaSearchTest.getSearchedPage().getText();
        Assert.assertEquals(text, "Thanks for visiting our website!");
    }

    @And("the user will able to click on Back To Home Page")
    public void theUserWillAbleToClickOnBackToHomePage()  {
        ClickUtils.click(driver,this.nykaaSearchTest.getBackTab());
       // WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getHomePage());

    }

    @Then("the Home Page should be display")
    public void theHomePageShouldBeDisplay() {
       // WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getHomePage());
        Assert.assertTrue(this.nykaaSearchTest.getHomePage().isDisplayed());
        //WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getSearchBar());
    }

    @When("the user enter incomplete name of product")
    public void theUserEnterIncompleteNameOfProduct() throws InterruptedException {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(this.data.get("Input"));
        this.nykaaSearchTest.getSearchBar().sendKeys(Keys.ENTER);
    }

    @Then("the product results should be displayed for incomplete product name")
    public void theProductResultsShouldBeDisplayedForIncompleteProductName() {
        WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getSearchBar());
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }

    @When("the user enter the product name with special characters")
    public void theUserEnterTheProductNameWithSpecialCharacters() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(this.data.get("Input"));
        this.nykaaSearchTest.getSearchBar().sendKeys(Keys.ENTER);
    }

    @Then("the product results should be displayed for special characters")
    public void theProductResultsShouldBeDisplayedForSpecialCharacters() throws InterruptedException {
        WaitUtils.waitTillVisible(driver,this.nykaaSearchTest.getSearchBar());
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }

    @When("the user enter the product name which is not in database")
    public void theUserEnterTheProductNameWhichIsNotInDatabase() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(this.data.get("Input"));
        this.nykaaSearchTest.getSearchBar().sendKeys(Keys.ENTER);
    }

    @Then("the product results should not be display for it")
    public void theProductResultsShouldNotBeDisplayForIt() {
        String text = this.nykaaSearchTest.getSearchedPage().getText();
        Assert.assertEquals(text, "Thanks for visiting our website!");
    }

    @When("the user enter the {string}")
    public void theUserEnterThe(String productDescription) {
        WebElement product = this.nykaaSearchTest.getSearchBar();
        product.sendKeys(productDescription);
        this.nykaaSearchTest.getSearchBar().sendKeys(Keys.ENTER);
    }

    @Then("the product will be displayed for both UPPERCASE and lowercase")
    public void theProductWillBeDisplayedForBothUPPERCASEAndLowercase() {
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }
}
