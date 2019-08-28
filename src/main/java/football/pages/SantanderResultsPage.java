package football.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SantanderResultsPage extends BasePage {

    //private List<WebElement> currentMatchdayFirstResult = findElements(By.cssSelector("p[class='styled__TextRegularContainer-sc-12cic8i-0 gHKnOS']"));
    private By currentMatchdayFirstResult = By.xpath("//*[@id=\"accordion__heading-0\"]/div/div[3]/div/div/div[2]/div/p");
    //private By matchdaysDropdownLocator = By.cssSelector("div[class='styled__DropDownContainer-sc-1yaayks-1 gECFwF']");
    private List<WebElement> matchdaysDropdownLocator = findElements(By.cssSelector("div[class='styled__DropDownContainer-sc-1yaayks-1 gECFwF']"));
    //This one is for locating the results depending on the wanted team
    private By resultsListLocator = By.cssSelector("div[class='styled__ResultContainer-qe32sx-6 iYHKYB']");
    //This is the name of the team for comparing with the desired one
    private By teamNamesListLocator = By.cssSelector("div[class='styled__ShieldContainer-x1xxh6-0 cJSjty']");
    //This one is inside the container of the resultsListLocator on position .get(2) for the score of the game in the current workday
    private By scorePerGameLocator = By.cssSelector("p[class='styled__TextRegularContainer-sc-12cic8i-0 gHKnOS']");
    //private By matchdaysAmount = By.cssSelector("li[class='styled__Item-sc-1yaayks-5 dtQSBA']");
    //private List<WebElement> matchdaysList = findElements(matchdaysAmount);
    //private By currentMatchday

    public SantanderResultsPage(WebDriver driver) {
        super(driver);
    }

    /*public void printMatchday(){
        System.out.println(getText(matchdaysAmount));
    }
    public void printMatchdays(){
        for (int i = 0; i < matchdaysList.size(); i++) {
            System.out.println(getText(matchdaysList.get(i)));
        }
    }*/

    //check if the current matchday has results or no, if no, move to the previous one
    public void checkMatchdayIsPlayed(){
        if(getText(currentMatchdayFirstResult).equals("VS")){
        //Move to the previous matchday
            moveToPreviousMatchday();
        }
        //DO the method for locating the X team and its score
    }

    public void moveToPreviousMatchday(){
        click(matchdaysDropdownLocator.get(1));
        String matchday = getText(matchdaysDropdownLocator.get(1).findElement(By.tagName("div")).findElement(By.tagName("p")));
        String[] data = matchday.split(" ", 2);
        int matchdayNumber = Integer.parseInt(data[1]);
        List<WebElement> matchdaysList = matchdaysDropdownLocator.get(1).findElement(By.tagName("ul")).findElements(By.tagName("li"));
        String lastMatchday = "Jornada 1";
        while (!matchday.equals(lastMatchday)){
            click(matchdaysList.get(matchdayNumber-2));
        }
    }

    public String getTeamLocator(String teamName){
        List<WebElement> namesDivList = findElements(teamNamesListLocator);
    //    List<WebElement> namesPList = namesDivList.findElements(By.tagName("p"));
        for (int i = 0; i < namesDivList.size(); i++) {
            if(getText(namesDivList.get(i)).indexOf(teamName) != -1){
                return getText(namesDivList.get(i));
            }
        }
        return null;
    }

    //In this method will be saved the points achieved by team X, first in the current workday, then in the previous workdays
    //by selecting the played game of the X team and inside that div select the tag p where is displayed the score 0 - 0
    public int getPointsTeamXperWorkday(By teamLocator){
        return 0;
    }
}
