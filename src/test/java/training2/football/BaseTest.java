package training2.football;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.laliga.com");
        //setLanguage();
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setLanguage(){
        List<WebElement> p = driver.findElements(By.cssSelector("styled__TextRegularContainer-sc-12cic8i-0 iqUYfN"));
        By languageDropdown = By.id("dropdownTitleId_1622");
        By spanish = By.cssSelector("li[class='styled__Item-sc-1yaayks-5 deobay']");
        if(p.get(1).getText().equals("English")){
            driver.findElement(languageDropdown).click();
            driver.findElement(spanish).click();
        }
    }

}

