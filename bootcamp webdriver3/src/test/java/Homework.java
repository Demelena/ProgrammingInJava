import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

public class Homework {
    private WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        File file = new File("src/test/resources");
        String path = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver" );
        driver = new FirefoxDriver();
    }

    // 1st test: valid email -> next = we see password screen
    @Test
    public void test1ValidEmail() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.id("identifierId")).sendKeys("demelena");
        driver.findElement(By.xpath("//span[text() = 'Next']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.id("headingText"), "Welcome"));
    }

    // 2nd test: click forget email -> next = we see find your email screen
    @Test
    public void tes2tForgotEmail() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.id("headingText"), "Find your email"));
    }

    // 3rd test: invalid email = couldn't find your google account
    @Test
    public void test3InvalidEmail() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.id("identifierId")).sendKeys("demeeeeeelena");
        driver.findElement(By.xpath("//span[text() = 'Next']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Boolean containsText = driver.getPageSource().contains("Couldn't find your Google Account");
    }

    // 4rd test: create account link
    @Test
    public void test4CreateAccount() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.xpath("//span[text() = 'Create account']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.id("headingText"), "Create your Google Account"));
    }

    // 5th test: 0 characters -> next = enter email ... error message
    @Test
    public void test5HandlingCharacters() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com/accounts");
        // driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
        Boolean containsText = driver.getPageSource().contains("Enter an email or phone number");
        Assert.assertTrue(containsText);
    }

    // 6th test: click learn more
    @Test
    public void test6LearnMore() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.xpath("//a[@jsname='JFyozc']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.xpath("//a[text() = 'Google Account Help']"), "Google Account Help"));
    }

    // 7th test: Dropdown select value
    @Test
    public void dropDownChangeLocToRu() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.xpath("//div[@jsname='LgbsSe']")).click();
        driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed']/div[@data-value='ru']")).click();
        String pageTitle = driver.findElement(By.id("headingText")).getText();
        Assert.assertEquals(pageTitle, "Вход");
    }

    @Test
    public void dropDown() {
        driver.get("https://google.com/accounts");
        driver.findElement(By.xpath("//div[@jsname='LgbsSe']")).click();
        driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed']/div[@data-value='da']")).click();
        String pageTitle = driver.findElement(By.id("headingText")).getText();
        Assert.assertEquals(pageTitle, "Log ind");
    }

    // 8th test: Help -> new tab
    @Test
    public void test8HelpNewTab() {
        String NewTabLink = Keys.chord(Keys.COMMAND,Keys.RETURN);
        driver.get("https://google.com/accounts");
        driver.findElement(By.xpath("//a[@jsname='JFyozc']")).sendKeys(NewTabLink);

        WebDriverWait wait2 = new WebDriverWait(driver, 5);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.xpath("//a[text() = 'Google Account Help']"), "Google Account Help"));
    }


}
