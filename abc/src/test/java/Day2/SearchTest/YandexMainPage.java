package Day2.SearchTest;

import org.openqa.selenium.By;

public class YandexMainPage {

    public static By searchInput = By.xpath("//input[@aria-label='Request']");
    public static By submitButton = By.xpath("//button[@type='submit']");
    public static By resultStats = By.xpath("//div[@class='serp-adv__found']");
}
