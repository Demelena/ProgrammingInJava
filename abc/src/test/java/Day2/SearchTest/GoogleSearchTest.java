package Day2.SearchTest;

import Day2.SearchTest.GoogleMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {


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
        String res = driver.findElement(GoogleMainPage.resultStats).getText();
        System.out.println(res);
    }

    private void submitSearch() {
        driver.findElement(GoogleMainPage.submitButton).click();
    }

    private void typeRequestInSearchInput() {
        driver.findElement(GoogleMainPage.searchInput).sendKeys("Portnov computer school");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void navigatingToMainPage() {
        String url = "http://google.com";
        driver.get(url);
    }
}
