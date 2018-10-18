package Day2.SearchTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleVideoSearchTest {

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
        clickVideoLink();
        printOutAmountOfResult();
    }

    private void clickVideoLink() {

        driver.findElement(GoogleVideoMainPage.clickVideoLink).click();
    }


    private void printOutAmountOfResult() {
        String res = driver.findElement(GoogleVideoMainPage.resultStats).getText();
        System.out.println(res);
    }

    private void submitSearch() {
        driver.findElement(GoogleVideoMainPage.submitButton).click();
    }

    private void typeRequestInSearchInput() {
        driver.findElement(GoogleVideoMainPage.searchInput).sendKeys("Portnov computer school");
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
