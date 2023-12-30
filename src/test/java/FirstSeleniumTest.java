import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {

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
    public void findEmailFieldTest(){
    WebElement element = driver.findElement(By.id("email"));
    WebElement element1 = driver.findElement(By.name("email"));
    WebElement element2 = driver.findElement(By.linkText("Create a Page"));
    WebElement element3 = driver.findElement(By.partialLinkText("a Page"));
    WebElement element4 = driver.findElement(By.cssSelector("#email"));
    WebElement element5 = driver.findElement(By.className("inputtext"));
    List<WebElement> element6  =driver.findElements(By.className("inputtext"));
        System.out.println(element6.size());

    assertNotNull(element6);

    }

    @Test
     public void findElementsByXpathTest(){

    WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
    WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
    WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
    WebElement forgotPassElement = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
    WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
    assertNotNull(emailElement);
    assertNotNull(passwordElement);
    assertNotNull(loginButtonElement);
    assertNotNull(forgotPassElement);
    assertNotNull(createNewAccButton);


    }
    @Test
    public void emailElement(){
    WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
    assertNotNull(emailElement);
    emailElement.sendKeys("Lev.gorfel@gmail.com");
    String emailValue = emailElement.getAttribute("value");
    assertEquals("Lev.gorfel@gmail.com", emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("123456");
        String passValue = passwordElement.getAttribute("value");
        assertEquals("123456", passValue);

        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        loginButtonElement.click();

    }
    @Test

    public void createNewAccButton() throws InterruptedException {
    WebElement createNewAccButtonElement = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
    assertNotNull(createNewAccButtonElement);
    createNewAccButtonElement.click();
    Thread.sleep(2000);
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
       firstNameElement.sendKeys("Moshe");
        String firstName = firstNameElement.getAttribute("value");
        assertEquals("Moshe", firstName);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Misha");
        String lastName = lastNameElement.getAttribute("value");
        assertEquals("Misha", lastName);

        WebElement emailOrNumElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(emailOrNumElement);
        emailOrNumElement.sendKeys("qwerty@gmail.com");
        String emailOrNumValue = emailOrNumElement.getAttribute("value");
        assertEquals("qwerty@gmail.com", emailOrNumValue);
        Thread.sleep(2000);

        WebElement reEnterEmailElement = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(reEnterEmailElement);
        reEnterEmailElement.sendKeys("korzhiki@gmail.com");
        String reEnterEmail = reEnterEmailElement.getAttribute("value");
        assertEquals("korzhiki@gmail.com", reEnterEmail);
        Thread.sleep(2000);


        WebElement newPassElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(newPassElement);
        newPassElement.sendKeys("11111");
        String newPass = newPassElement.getAttribute("value");
        assertEquals("11111", newPass);
        Thread.sleep(2000);

        WebElement femaleTestElement = driver.findElement(By.xpath("//input[@value='1']"));
        assertNotNull(femaleTestElement);

        WebElement maleTestElement = driver.findElement(By.xpath("//input[@value='2']"));
        assertNotNull(maleTestElement);

        WebElement customTestElement = driver.findElement(By.xpath("//input[@value='-1']"));
        assertNotNull(maleTestElement);
        customTestElement.click();
        Thread.sleep(2000);

        WebElement pronounSelectElement = driver.findElement(By.xpath("//select[@aria-label='Select your pronoun']"));
        assertNotNull(pronounSelectElement);
        pronounSelectElement.click();
        Thread.sleep(2000);

        WebElement choosePronounElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
        assertNotNull(choosePronounElement);
        choosePronounElement.sendKeys("They");
        Thread.sleep(2000);

        WebElement visiblePronounElement= driver.findElement(By.xpath("//div[@class='_83kf']"));
        assertNotNull(visiblePronounElement);

        WebElement genderOptionalElement = driver.findElement(By.xpath("//input[@name='custom_gender']"));
        assertNotNull(genderOptionalElement);
        genderOptionalElement.sendKeys("Female");
        String genderOption = genderOptionalElement.getAttribute("value");
        assertEquals("Female", genderOption);
        Thread.sleep(2000);

        WebElement sighUpElement = genderOptionalElement.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"));
        assertNotNull(sighUpElement);
        sighUpElement.click();
        Thread.sleep(2000);

        }

}





