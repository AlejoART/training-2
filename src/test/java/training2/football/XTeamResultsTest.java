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
    private String TEAMNAME = "Osasuna";
    private int score = 0;

    @Test
    public void checkOsasunaResuts(){
        Match[] matches;
        HomePage homePage = new HomePage(getDriver());
        homePage.goToLigaSantander();

        SantanderPage santanderPage = new SantanderPage(getDriver());
        santanderPage.goToResults();

        SantanderResultsPage santanderResultsPage = new SantanderResultsPage(getDriver());
        int matchDays = santanderResultsPage.getMatchdaysAmount();
        matches = new Match[matchDays];


        for (int i = 0; i < matchDays; i++) {
            String[] match = santanderResultsPage.getTheCurrentMatchdayMatch(TEAMNAME);

            if (checkIfNull(match)){
                santanderResultsPage.moveToPreviousMatchday();
                continue;
            }

            Match matchEntity = new Match();

            matchEntity.setTeam1(match[0]);
            matchEntity.setTeam2(match[1]);
            matchEntity.setResultTeam1(Integer.parseInt(match[2]));
            matchEntity.setResultTeam2(Integer.parseInt(match[3]));

            matches[i] = matchEntity;
            santanderResultsPage.moveToPreviousMatchday();
        }

        Team team = new Team();

        for (Match match: matches) {
            if (match.getTeam1().contains("Osasuna".toUpperCase())){
                score += match.addPointsToTeam1(match.getResultTeam1(),match.getResultTeam2());
                team.setName(match.getTeam1());
            }
            if(match.getTeam2().contains("Osasuna".toUpperCase())){
                score += match.addPointsToTeam2(match.getResultTeam1(),match.getResultTeam2());
                team.setName(match.getTeam2());
            }
        }

        team.setScore(score);
        team.setPlayedGames(matches.length);

        santanderPage.goToClassification();

        SantanderClassificationPage santanderClassificationPage = new SantanderClassificationPage(getDriver());

        Assert.assertEquals(team.getScore(),santanderClassificationPage.getScoreTeamX(team.getName()));
        Assert.assertEquals(team.getPlayedGames(),santanderClassificationPage.getPlayedGamesTeamX(team.getName()));
    }

    private Boolean checkIfNull(String[] match){
        for(String element : match){
            if(element != null)
                return false;
        }
        return true;
    }
}
