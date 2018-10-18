package Day2.SearchTest;

import org.openqa.selenium.By;

public class YahooMainPage {


    public static By searchInput = By.xpath("//input[@id='uh-search-box']");
    public static By submitButton = By.xpath("//button[@id='uh-search-button']");
    public static By resultStats = By.xpath("//div[@class='compPagination']");
    public static By span = By.tagName("span");

}

