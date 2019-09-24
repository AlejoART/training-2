package football.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SantanderResultsPage extends BasePage {

    private List<WebElement> matchdaysDropdownElement;
    //This is the list for the 10 divs that contains the names of the teams and the result of the game in the tags p
    private List<WebElement> matchesListElement;
    private By matchDiv = By.cssSelector("div[class='styled__GameweekTitle-qe32sx-2 jFqvgQ']");
    private By resultsContainerLocator = By.cssSelector("div[class='show styled__ShowLoadedContainer-sc-191gwr0-0 khRXzW']");

    public SantanderResultsPage(WebDriver driver) {
        super(driver);
    }

    public String[] getTheCurrentMatchdayMatch(String teamName){
        WebDriverWait ewait1 = new WebDriverWait(driver,10);
        ewait1.until(ExpectedConditions.visibilityOfElementLocated(resultsContainerLocator));

        matchesListElement = findElements(By.cssSelector("div[class='styled__ResultContainer-qe32sx-6 iYHKYB']"));
        String [] match = new String[4];

        for (int i = 0; i < matchesListElement.size(); i++) {
            List<WebElement> eachMatch = matchesListElement.get(i).findElements(By.tagName("p"));
            if (!getText(eachMatch.get(1)).equals("VS")) {
                if (getText(eachMatch.get(0)).contains(teamName.toUpperCase()) || getText(eachMatch.get(4)).contains(teamName.toUpperCase())) {
                    match[0] = getText(eachMatch.get(0));
                    match[1] = getText(eachMatch.get(4));
                    match[2] = getText(eachMatch.get(1));
                    match[3] = getText(eachMatch.get(3));
                    break;
                }
            }
        }
        return match;
    }

    public void moveToPreviousMatchday(){
        matchdaysDropdownElement = findElements(By.cssSelector("div[class='styled__DropDownContainer-sc-1yaayks-1 gECFwF']"));
        click(matchdaysDropdownElement.get(1));
        String matchday = getText(matchdaysDropdownElement.get(1).findElement(By.tagName("p")));
        String[] data = matchday.split(" ", 2);
        int matchdayNumber = Integer.parseInt(data[1]);
        List<WebElement> matchdaysList = matchdaysDropdownElement.get(1).findElement(By.tagName("ul")).findElements(By.tagName("li"));

        if (matchdayNumber!= 1){
            WebDriverWait ewait = new WebDriverWait(driver,10);
            ewait.until(ExpectedConditions.elementToBeClickable(matchdaysList.get(matchdayNumber-2)));

            click(matchdaysList.get(matchdayNumber-2));

            WebDriverWait ewait1 = new WebDriverWait(driver,10);
            ewait1.until(ExpectedConditions.visibilityOfElementLocated(resultsContainerLocator));

            switchToTab(1);
        }
    }

    public int getMatchdaysAmount(){
        WebDriverWait ewait1 = new WebDriverWait(driver,10);
        ewait1.until(ExpectedConditions.visibilityOfElementLocated(matchDiv));

        matchdaysDropdownElement = findElements(By.cssSelector("div[class='styled__DropDownContainer-sc-1yaayks-1 gECFwF']"));

        String matchday = getText(matchdaysDropdownElement.get(1));
        String[] data = matchday.split(" ", 2);
        return Integer.parseInt(data[1]);
    }
}
