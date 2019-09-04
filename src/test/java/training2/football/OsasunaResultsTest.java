package training2.football;

import football.entities.Match;
import football.entities.Team;
import football.pages.HomePage;
import football.pages.SantanderPage;
import football.pages.SantanderResultsPage;
import org.testng.annotations.Test;

public class OsasunaResultsTest extends BaseTest {

    @Test
    public void checkOsasunaResuts(){

        HomePage homePage = new HomePage(getDriver());
        homePage.goToLigaSantander();

        SantanderPage santanderPage = new SantanderPage(getDriver());
        santanderPage.goToResults();

        SantanderResultsPage santanderResultsPage = new SantanderResultsPage(getDriver());
        String[] match = santanderResultsPage.getTheCurrentMatchdayMatch("Osasuna");

        Match matchEntity = new Match(match[0], match[2], match[1]);
        Team team = new Team();
        matchEntity.setResultTeam1(match[2]);
        int result1 = matchEntity.getResultTeam1();
        matchEntity.setResultTeam1(match[2]);
        int result2 = matchEntity.getResultTeam2();
        if(matchEntity.getTeam1().contains("Osasuna".toUpperCase())){
            team.setName(matchEntity.getTeam1());
            team.setScore(matchEntity.addPointsToTeam1(result1, result2));
        }else if (matchEntity.getTeam2().contains("Osasuna".toUpperCase())){
            team.setName(matchEntity.getTeam2());
            team.setScore(matchEntity.addPointsToTeam2(result1,result2));
        }

    }
}
