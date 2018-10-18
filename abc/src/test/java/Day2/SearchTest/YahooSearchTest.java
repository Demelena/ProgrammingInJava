package Day2.SearchTest;

import Day2.SearchTest.YahooMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YahooSearchTest {


    private WebDriver driver;




    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "/users/elena/IdeaProjects/abc/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() throws Exception {
        navigatingToMainPage();
        typeRequestInSearchInput();
        submitSearch();
        printOutAmountOfResult();
    }

    private void printOutAmountOfResult() {
        String res = driver.findElement(YahooMainPage.resultStats).findElement(YahooMainPage.span).getText();
        System.out.println(res);
    }

    private void submitSearch() {
        driver.findElement(YahooMainPage.submitButton).click();
    }

    private void typeRequestInSearchInput() {
        driver.findElement(YahooMainPage.searchInput).sendKeys("Portnov computer school");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void navigatingToMainPage() {
        String url = "https://www.yahoo.com/";
        driver.get(url);
    }

}
