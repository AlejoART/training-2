package training2.football;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.laliga.com");
        setLanguage();
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setLanguage(){
        By languageDropdown = By.cssSelector("div[class='styled__DropdownContainer-owktxg-6 beDdRJ']");
        By spanish = By.cssSelector("li[class='styled__Item-sc-1yaayks-5 deobay']");
        if(driver.findElement(languageDropdown).getText().equals("English")){
            driver.findElement(languageDropdown).click();
            driver.findElement(spanish).click();
        }
    }

}

