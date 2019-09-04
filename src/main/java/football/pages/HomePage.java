package football.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By ligaSantanderLocator = By.cssSelector("div[class='styled__MenuItemContainer-hjtxxq-0 giGkww']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLigaSantander(){

        WebDriverWait ewait1 = new WebDriverWait(driver,10);
        ewait1.until(ExpectedConditions.visibilityOfElementLocated(ligaSantanderLocator));

        click(ligaSantanderLocator);

    }
}
