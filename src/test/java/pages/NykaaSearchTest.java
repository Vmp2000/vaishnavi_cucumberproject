package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.BeforeTest;


public class NykaaSearchTest {
    private WebDriver driver;
    public NykaaSearchTest(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);}
    // WebDriver driver;
    @FindBy(
            xpath = "//input[@placeholder='Search on Nykaa']"
    )
    private WebElement SearchBar;
    @FindBy(
            xpath = "//input[@placeholder='Search on Nykaa']"
    )
    WebElement click;
    @FindBy(
            xpath = "//div[@class='css-lgbws3']"
    )
    WebElement searchBarPage;
    @FindBy(
            xpath = "//div[@class='css-6cdipv']"
    )
    WebElement dropDown;
    @FindBy(
            xpath = "//div[text()='Thanks for visiting our website!']"
    )
    WebElement searchedPage;
    @FindBy(
            xpath = "//button[text()='Back to Home']"
    )
    WebElement backTab;
    @FindBy(
            xpath = "//div[@class='css-97pv2q']"
    )
    WebElement homePage;

//    public NykaaSearchTest(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

//   // @BeforeTest
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        this.driver = new ChromeDriver();
//    }

    public WebElement getSearchBar() {
        return this.SearchBar;
    }

    public WebElement getClick() {
        return this.click;
    }

    public WebElement getSearchBarPage() {
        return this.searchBarPage;
    }

    public WebElement getDropDown() {
        return this.dropDown;
    }

    public WebElement getSearchedPage() {
        return this.searchedPage;
    }

    public WebElement getBackTab() {
        return this.backTab;
    }

    public WebElement getHomePage() {
        return this.homePage;
    }
}




