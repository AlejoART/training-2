package training2.football;

import football.pages.HomePage;
import football.pages.SantanderPage;
import football.pages.SantanderResultsPage;
import org.testng.annotations.Test;

public class OsasunaResultsTest extends BaseTest {

    @Test
    public void checkOsasunaResuts() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        homePage.goToLigaSantander();

        SantanderPage santanderPage = new SantanderPage(getDriver());
        santanderPage.goToResults();

        SantanderResultsPage santanderResultsPage = new SantanderResultsPage(getDriver());
        //santanderResultsPage.printMatchday();
    }
}
