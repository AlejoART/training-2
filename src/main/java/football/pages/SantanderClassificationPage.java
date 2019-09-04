package football.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SantanderClassificationPage extends BasePage {

    private By singleRow = By.cssSelector("div[class='styled__StandingTabBody-d1op5e-8 fMRhvA']");
    private List<WebElement> teamsList;
    private List<WebElement> teamRow;

    private int score = 0;
    private int playedGames = 0;
    public SantanderClassificationPage(WebDriver driver) {
        super(driver);
    }

    public int getScoreTeamX(String teamName){
        WebDriverWait ewait1 = new WebDriverWait(driver,10);
        ewait1.until(ExpectedConditions.elementToBeClickable(singleRow));

        teamsList = findElements(By.cssSelector("div[class='styled__ShieldContainer-x1xxh6-0 fTVURw']"));
        teamRow = findElements(By.cssSelector("div[class='styled__StandingTabBody-d1op5e-8 fMRhvA']"));
        for (int i = 0; i < teamsList.size(); i++) {
            if(getText(teamsList.get(i)).equals(teamName)) {
                score = Integer.parseInt(getText(teamRow.get(i).findElements(By.cssSelector("div[class='styled__TableBody-d1op5e-9 ksrmJh']")).get(0)));
                break;
            }
        }
        return score;
    }

    public int getPlayedGamesTeamX(String teamName){
        for (int i = 0; i < teamsList.size(); i++) {
            if(getText(teamsList.get(i)).equals(teamName)) {
                playedGames = Integer.parseInt(getText(teamRow.get(i).findElements(By.cssSelector("div[class='styled__TableBody-d1op5e-9 ksrmJh']")).get(1)));
                break;
            }
        }
        return playedGames;
    }
}
