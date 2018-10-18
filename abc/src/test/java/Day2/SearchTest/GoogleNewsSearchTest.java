package Day2.SearchTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleNewsSearchTest {

    private static By clickNewsLink;
    private static By resultStats;
    private static By submitButton;
    private static By searchInput;
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
        clickNewsLink();
        printOutAmountOfResult();
    }

    private void clickNewsLink() {

        driver.findElement(GoogleNewsMainPage.clickNewsLink).click();
    }


    private void printOutAmountOfResult() {
        String res = driver.findElement(GoogleNewsMainPage.resultStats).getText();
        System.out.println(res);
    }

    private void submitSearch() {
        driver.findElement(GoogleNewsMainPage.submitButton).click();
    }

    private void typeRequestInSearchInput() {
        driver.findElement(GoogleNewsMainPage.searchInput).sendKeys("Portnov computer school");
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
