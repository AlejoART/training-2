package football.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SantanderResultsPage extends BasePage {

    private List<WebElement> matchdaysDropdownElement = findElements(By.cssSelector("div[class='styled__DropDownContainer-sc-1yaayks-1 gECFwF']"));
    //This is the list for the 10 divs that contains the names of the teams and the result of the game in the tags p
    private List<WebElement> matchesListElement = findElements(By.cssSelector("div[class='styled__ResultContainer-qe32sx-6 iYHKYB']"));
    private By resultsContainerLocator = By.cssSelector("div[class='show styled__ShowLoadedContainer-sc-191gwr0-0 khRXzW']");

    public SantanderResultsPage(WebDriver driver) {
        super(driver);
    }

    public String[] getTheCurrentMatchdayMatch(String teamName){
        String [] match = new String[3];
        String team1 = null;
        String team2 = null;
        String result = null;
        for (int i = 0; i < matchesListElement.size(); i++) {
            List<WebElement> eachMatch = matchesListElement.get(i).findElements(By.tagName("p"));
            if(getText(eachMatch.get(0)).contains(teamName.toUpperCase())){
                team1 = getText(eachMatch.get(0));
                result = getText(eachMatch.get(1));
                team2 = getText(eachMatch.get(2));
            }
            if (getText(eachMatch.get(2)).contains(teamName.toUpperCase())) {
                team1 = getText(eachMatch.get(0));
                result = getText(eachMatch.get(1));
                team2 = getText(eachMatch.get(2));
            }
        }
        match[0] = team1;
        match[1] = result;
        match[2] = team2;

        return match;
    }

    public void checkMatchdayIsPlayed(String teamName){
        String [] match = getTheCurrentMatchdayMatch(teamName);
        if(match[1].equals("VS"))
            moveToPreviousMatchday(teamName);

        //DO the method for locating the X team and its score
    }

    public void moveToPreviousMatchday(String teamName){
        click(matchdaysDropdownElement.get(1));
        String matchday = getText(matchdaysDropdownElement.get(1).findElement(By.tagName("div")).findElement(By.tagName("p")));
        String[] data = matchday.split(" ", 2);
        int matchdayNumber = Integer.parseInt(data[1]);
        List<WebElement> matchdaysList = matchdaysDropdownElement.get(1).findElement(By.tagName("ul")).findElements(By.tagName("li"));
        String lastMatchday = "Jornada 1";
        if (!matchday.equals(lastMatchday)){
            click(matchdaysList.get(matchdayNumber-2));

            WebDriverWait ewait1 = new WebDriverWait(driver,10);
            ewait1.until(ExpectedConditions.visibilityOfElementLocated(resultsContainerLocator));

            checkMatchdayIsPlayed(teamName);
        }

    }


    //In this method will be saved the points achieved by team X, first in the current matchday, then in the previous matchdays
    //by selecting the played game of the X team and inside that div select the tag p where is displayed the score 0 - 0
    public int getPointsTeamXperMtachday(By teamLocator){
        return 0;
    }
}
