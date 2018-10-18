package Day2.SearchTest;

import org.openqa.selenium.By;

public class GoogleBooksMainPage {

    public static By searchInput = By.xpath("//input[@id='oc-search-input']");
    public static By submitButton = By.xpath("//input[@value='Search Books']");
    public static By resultStats = By.id("resultStats");

}
