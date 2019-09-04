package training2.football;

import football.entities.Match;
import football.entities.Team;
import football.pages.HomePage;
import football.pages.SantanderClassificationPage;
import football.pages.SantanderPage;
import football.pages.SantanderResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XTeamResultsTest extends BaseTest {
    private Match[] matches;
    private int score = 0;

    @Test
    public void checkOsasunaResuts(){

        HomePage homePage = new HomePage(getDriver());
        homePage.goToLigaSantander();

        SantanderPage santanderPage = new SantanderPage(getDriver());
        santanderPage.goToResults();

        SantanderResultsPage santanderResultsPage = new SantanderResultsPage(getDriver());
        int matchdays = santanderResultsPage.getMatchdaysAmount();
        matches = new Match[matchdays];

        for (int i = 0; i < matchdays; i++) {
            String[] match = santanderResultsPage.getTheCurrentMatchdayMatch("Osasuna");
            Match matchEntity = new Match(match[0], match[2], match[1]);
            if(matchEntity.getResult().equals("VS")) {
                santanderResultsPage.moveToPreviousMatchday();
                break;
            }else{
                matchEntity.setResultTeam1(match[1]);
                matchEntity.setResultTeam2(match[1]);
                matches[i] = matchEntity;
                santanderResultsPage.moveToPreviousMatchday();
            }
        }
        Team team = new Team();
        for (int i = 0; i < matches.length; i++) {
            if(matches[i].getTeam1().contains("Osasuna".toUpperCase())){
                score += matches[i].addPointsToTeam1(matches[i].getResultTeam1(),matches[i].getResultTeam2());
                team.setName(matches[i].getTeam1());
            }
            if(matches[i].getTeam2().contains("Osasuna".toUpperCase())){
                score += matches[i].addPointsToTeam2(matches[i].getResultTeam1(),matches[i].getResultTeam2());
                team.setName(matches[i].getTeam2());
            }
        }
        team.setScore(score);
        team.setPlayedGames(matches.length);

        santanderPage.goToClassification();

        SantanderClassificationPage santanderClassificationPage = new SantanderClassificationPage(getDriver());

        Assert.assertEquals(team.getScore(),santanderClassificationPage.getScoreTeamX(team.getName()));
        Assert.assertEquals(team.getPlayedGames(),santanderClassificationPage.getPlayedGamesTeamX(team.getName()));
    }
}
