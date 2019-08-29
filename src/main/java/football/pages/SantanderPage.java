package football.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SantanderPage extends BasePage {
    private By resultsLocator = By.xpath("//*[@id=\"__next\"]/div/header/div[2]/div/div[2]/div/div/div[2]/span/a");
    private By clasifficationLocator = By.xpath("//*[@id=\"__next\"]/div/header/div[2]/div/div[2]/div/div/div[3]/span/a");
    private By dropdownText = By.xpath("//*[@id=\"dropdownTitleId_211\"]/div/p");
    private By resultsContainerLocator = By.cssSelector("div[class='show styled__ShowLoadedContainer-sc-191gwr0-0 khRXzW']");

    public SantanderPage(WebDriver driver) {
        super(driver);
    }

    public void goToResults(){

        WebDriverWait ewait1 = new WebDriverWait(driver,10);
        ewait1.until(ExpectedConditions.visibilityOfElementLocated(resultsLocator));

        click(resultsLocator);

        WebDriverWait ewait2 = new WebDriverWait(driver,10);
        ewait2.until(ExpectedConditions.visibilityOfElementLocated(resultsContainerLocator));
    }

    public void goToClassification(){
        WebDriverWait ewait1 = new WebDriverWait(driver,10);
        ewait1.until(ExpectedConditions.visibilityOfElementLocated(resultsLocator));

        click(clasifficationLocator);

        WebDriverWait ewait2 = new WebDriverWait(driver,10);
        ewait2.until(ExpectedConditions.visibilityOfElementLocated(resultsContainerLocator));
    }
}
