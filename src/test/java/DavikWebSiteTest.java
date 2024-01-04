import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DavikWebSiteTest {
    private static final String HOME_PAGE_URL = "https://daviktapes.com/";
    private static WebDriver driver;


    @BeforeAll
    public static void classSetUp(){
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown(){
        SharedDriver.closeDriver();
    }

    @AfterEach
    public void testTestDown(){
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void homePageUrlTest(){

        String actualUrl = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL,actualUrl,"URLs do not match");
}
@Test
public void waitAndClickTest(){
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Company']")));
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Company']")));
}

@Test
    public void actionTest(){

        driver.navigate().to(HOME_PAGE_URL);
    WebElement element = driver.findElement(By.xpath("//*[text()='Company']"));
    Actions action = new Actions(driver);
    action.moveToElement(element).build().perform();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Company']")));


    WebElement home = driver.findElement(By.xpath("//*[text()='Home']"));
    action.moveToElement(home).build().perform();
   WebDriverWait waitH = new WebDriverWait(driver, Duration.ofSeconds(10));
   waitH.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Home']")));


    WebElement products = driver.findElement(By.xpath("//*[text()='Products']"));
    action.moveToElement(products).build().perform();
    WebDriverWait waitP = new WebDriverWait(driver, Duration.ofSeconds(10));
    waitP.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Products']")));


    WebElement Industries = driver.findElement(By.xpath("//*[text()='Industries']"));
    action.moveToElement(Industries).build().perform();
    WebDriverWait waitI = new WebDriverWait(driver, Duration.ofSeconds(10));
    waitI.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Industries']")));

    WebElement knowledge = driver.findElement(By.xpath("//*[@id='menu-item-132']//following-sibling::*[@id='menu-item-2552']"));
    action.moveToElement(knowledge).build().perform();
    WebDriverWait waitK = new WebDriverWait(driver, Duration.ofSeconds(10));
    waitK.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-132']//following-sibling::*[@id='menu-item-2552']")));


}

}
