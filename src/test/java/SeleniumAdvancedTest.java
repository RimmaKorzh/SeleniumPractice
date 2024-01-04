import org.junit.internal.Checks;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumAdvancedTest {


    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
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
    public void errorMassage() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Last name']")).click();
        WebElement errorLastName = driver.findElement(By.xpath("//*[contains(text(), 'your name')]"));
        assertNotNull(errorLastName);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@aria-label='First name']")).click();
        WebElement errorFirstName = driver.findElement(By.xpath("//*[contains(text(), 'your name')]"));
        assertNotNull(errorFirstName);
        Thread.sleep(2000);

    }
    @ParameterizedTest
    @ValueSource(strings = {"2","16","25"})
    public void dayTestParametrized(String dayInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@title='Day']")).click();
        driver.findElement(By.xpath("//*[text()='"+dayInput+"']")).click();
        String dayValue=driver.findElement(By.xpath("//*[@title='Day']")).getAttribute("value");
        assertEquals(dayInput, dayValue);

    }
@ParameterizedTest
    @ValueSource(strings = {"2", "3", "10", "11"})
    public  void monthTestParametrized(String monthInput) throws InterruptedException {
    driver.findElement(By.xpath("//*[text()='Create new account']")).click();
    assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@title='Month']")).click();
    driver.findElement(By.xpath("//*[@value='"+monthInput+"']")).click();
    String monthValue =driver.findElement(By.xpath("//*[@title='Month']")).getAttribute("value");
    assertEquals(monthInput, monthValue);


}
    @ParameterizedTest
    @ValueSource(strings = {"1905", "1950", "2024"})
    public  void yearTestParametrized(String yearInput) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@title='Year']")).click();
        driver.findElement(By.xpath("//*[text()='"+yearInput+"']")).click();
        String yearValue =driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");
        assertEquals(yearInput, yearValue);

 }
@Test
    public void radioButtonTest() throws InterruptedException {
    driver.findElement(By.xpath("//*[text()='Create new account']")).click();
    assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
    Thread.sleep(2000);

       WebElement maleRadioButton= driver.findElement(By.xpath("//input[@type='radio']//preceding-sibling::*[text()='Male']"));
       assertNotNull(maleRadioButton);
       maleRadioButton.click();
       Thread.sleep(1000);

    WebElement femaleRadioButton= driver.findElement(By.xpath("//input[@type='radio']//preceding-sibling::*[text()='Female']"));
    assertNotNull(femaleRadioButton);
    femaleRadioButton.click();
    Thread.sleep(1000);


}
@Test
    public void termsLinkTest() throws InterruptedException {
    driver.findElement(By.xpath("//*[text()='Create new account']")).click();
    assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
    Thread.sleep(2000);

    String dataPolicyXpath ="//*[contains(text(), 'People who use')]//following-sibling::*[@id='non-users-notice-link']";
    driver.findElement(By.xpath(dataPolicyXpath)).click();
    switchToNewTab(driver);

    assertEquals("https://www.facebook.com/help/637205020878504",driver.getCurrentUrl());

    }
    public static void switchToNewTab(WebDriver driver){
      for(String windowHandle : driver.getWindowHandles()){
          driver.switchTo().window(windowHandle);
      }
    }

}















