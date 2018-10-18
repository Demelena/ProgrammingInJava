package Day2.SearchTest;

import org.openqa.selenium.By;

public class GoogleVideoMainPage {


    public static By searchInput = By.xpath("//input[@id='lst-ib']");
    public static By submitButton = By.xpath("//input[@value='Пошук Google']");
    public static By clickVideoLink = By.xpath("//a[text()='Відео']");
    public static By clickNewsLink = By.xpath("//a[text()='Новини']");
    public static By resultStats = By.id("resultStats");


}
