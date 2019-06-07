
import iua.HomeIUAPage;
import iua.LoginPage;
import iua.NewLetterPage;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class TestClassIUA {

    private WebDriver driver;
    private HomeIUAPage homeIUA;
    private LoginPage loginPage;
    private NewLetterPage newLetterPage;
    private String url = "https://www.i.ua/",
                   senderEmail = "as0701866@i.ua",
                   recipientEmail = "as0701866@mailinator.com",
                   password = "123qwe321ewq",
                   wrongPassword = "123qwe",
                   subject = "Test",
                   letterText = "Hello";

    @Before
    public void setUpTest() {
        File file = new File(".\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get(url);

    }


    @org.junit.Test
    public void loginToIUAAndSendMessage() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homeIUA = loginPage.loginToIUa(senderEmail,password);
        newLetterPage = homeIUA.goToCreateNewLetter().
                sendNewMessage(recipientEmail, subject, letterText);
        Assert.assertEquals("Письмо успешно отправлено адресатам", newLetterPage.getSendMessage());
        driver.quit();
    }

    @org.junit.Test
    public void loginToIUAShouldWork() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homeIUA = loginPage.loginToIUa(senderEmail,password);
        // Assert.assertEquals(senderEmail, homeIUA.getInboxMessage());
        Assert.assertTrue( homeIUA.isElementСreateLetterPresent());
        driver.quit();
    }

    @org.junit.Test
    public void loginToIUAWithIncorrectPasswordShouldNotWork() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homeIUA = loginPage.loginToIUa(senderEmail,wrongPassword);
        Assert.assertEquals("Неверный логин или пароль", loginPage.getLoginMessage());
        driver.quit();
    }





}
