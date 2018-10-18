package Day2.SearchTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YandexSearchTest {



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

    private void navigatingToMainPage() {
        String url = "https://yandex.com";
        driver.get(url);
    }

    private void typeRequestInSearchInput() {

        driver.findElement(YandexMainPage.searchInput).sendKeys("Portnov computer school");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

        private void submitSearch () {
            driver.findElement(YandexMainPage.submitButton).click();
        }

        private void printOutAmountOfResult () {
            String res = driver.findElements(YandexMainPage.resultStats).get(0).getText();
            System.out.println(res);
        }
    }