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
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

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
        this.nykaaSearchTest.getSearchBar().click();
    }

    @Then("the drop down appear")
    public void theDropDownAppear() throws InterruptedException {
        Thread.sleep(3000L);
        Assert.assertTrue(this.nykaaSearchTest.getDropDown().isDisplayed());
        Thread.sleep(3000L);
    }

    @And("the user enter the product name")
    public void the_user_enter_the_product_name() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{(CharSequence)this.data.get("Input")});
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{Keys.ENTER});
    }

    @Then("the product results should be displayed")
    public void theProductResultsShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(3000L);
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }

    @When("the user enter the product name in marathi")
    public void theUserEnterTheProductNameInMarathi() throws InterruptedException {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{(CharSequence)this.data.get("Input")});
        Thread.sleep(2000L);
    }

    @And("The user is able to click on enter key")
    public void theUserIsAbleToClickOnEnterKey() throws InterruptedException {
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{Keys.ENTER});
        Thread.sleep(2000L);
    }

    @Then("the sorry message will be displayed")
    public void theSorryMessageWillBeDisplayed() {
        String text = this.nykaaSearchTest.getSearchedPage().getText();
        Assert.assertEquals(text, "Thanks for visiting our website!");
    }

    @And("the user will able to click on Back To Home Page")
    public void theUserWillAbleToClickOnBackToHomePage() throws InterruptedException {
        this.nykaaSearchTest.getBackTab().click();
        Thread.sleep(2000L);
    }

    @Then("the Home Page should be display")
    public void theHomePageShouldBeDisplay() {
        Assert.assertTrue(this.nykaaSearchTest.getHomePage().isDisplayed());
    }

    @When("the user enter incomplete name of product")
    public void theUserEnterIncompleteNameOfProduct() throws InterruptedException {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{(CharSequence)this.data.get("Input")});
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{Keys.ENTER});
    }

    @Then("the product results should be displayed for incomplete product name")
    public void theProductResultsShouldBeDisplayedForIncompleteProductName() throws InterruptedException {
        Thread.sleep(5000L);
        Thread.sleep(3000L);
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }

    @When("the user enter the product name with special characters")
    public void theUserEnterTheProductNameWithSpecialCharacters() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{(CharSequence)this.data.get("Input")});
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{Keys.ENTER});
    }

    @Then("the product results should be displayed for special characters")
    public void theProductResultsShouldBeDisplayedForSpecialCharacters() throws InterruptedException {
        Thread.sleep(5000L);
        Thread.sleep(3000L);
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }

    @When("the user enter the product name which is not in database")
    public void theUserEnterTheProductNameWhichIsNotInDatabase() {
        this.nykaaSearchTest = new NykaaSearchTest(this.driver);
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{(CharSequence)this.data.get("Input")});
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{Keys.ENTER});
    }

    @Then("the product results should not be display for it")
    public void theProductResultsShouldNotBeDisplayForIt() {
        String text = this.nykaaSearchTest.getSearchedPage().getText();
        Assert.assertEquals(text, "Thanks for visiting our website!");
    }

    @When("the user enter the {string}")
    public void theUserEnterThe(String productDescription) {
        WebElement product = this.nykaaSearchTest.getSearchBar();
        product.sendKeys(new CharSequence[]{productDescription});
        this.nykaaSearchTest.getSearchBar().sendKeys(new CharSequence[]{Keys.ENTER});
    }

    @Then("the product will be displayed for both UPPERCASE and lowercase")
    public void theProductWillBeDisplayedForBothUPPERCASEAndLowercase() {
        WebElement search_info = this.nykaaSearchTest.getSearchBarPage();
        Assert.assertTrue(search_info.isDisplayed());
    }
}
