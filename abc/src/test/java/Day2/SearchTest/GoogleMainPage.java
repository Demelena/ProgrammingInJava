package Day2.SearchTest;

import org.openqa.selenium.By;

public class GoogleMainPage {


        public static By searchInput = By.xpath("//input[@id='lst-ib']");
        public static By submitButton = By.xpath("//input[@value='Пошук Google']");
        public static By resultStats = By.id("resultStats");
        public static By printOutAmountOfResults = By.id("resultStats");

    public static By clickVideoLink;
}
