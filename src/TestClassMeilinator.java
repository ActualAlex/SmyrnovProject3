
import meilinator.HomeMailinatorPage;
import meilinator.InboxPage;
import meilinator.MessagePage;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class TestClassMeilinator {

     private WebDriver driver;
     private HomeMailinatorPage homeMailinatorPage;
     private InboxPage inboxPage;
     private MessagePage messagePage;
     private String url = "https://www.mailinator.com/",
                    sender = "Алексей",
                    subject = "Test",
                    senderEmail = "as0701866@i.ua",
                    recipientEmail = "as0701866@mailinator.com",
                    letterText = "Hello";

    @Before
    public void setUpTest() {
        File file = new File(".\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get(url);
    }

    @org.junit.Test
    public void checkSenderField () {
        homeMailinatorPage = PageFactory.initElements(driver, HomeMailinatorPage.class);
        inboxPage = homeMailinatorPage.findNewLetter(recipientEmail);
        Assert.assertEquals(sender, inboxPage.getSenderText());
        driver.quit();
    }

    @org.junit.Test
    public void checkSubjectField () {
        homeMailinatorPage = PageFactory.initElements(driver, HomeMailinatorPage.class);
        inboxPage = homeMailinatorPage.findNewLetter(recipientEmail);
        Assert.assertEquals(subject, inboxPage.getSubjectText());
        driver.quit();
    }

    @org.junit.Test
    public void checkInboxMessage () {
        homeMailinatorPage = PageFactory.initElements(driver, HomeMailinatorPage.class);
        messagePage = homeMailinatorPage.findNewLetter(recipientEmail)
                .toNewMail();
        Assert.assertTrue( messagePage.isMessagePresent(letterText));
        driver.quit();
    }
}
