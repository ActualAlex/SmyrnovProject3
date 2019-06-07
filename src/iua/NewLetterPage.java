package iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage {


    private WebDriver driver;

    @FindBy(id = "to")
    private WebElement sendTo;

    @FindBy(name = "subject")
    private WebElement subject;

    @FindBy(id = "text")
    private WebElement letterContent;

    @FindBy(name = "send")
    private WebElement sendButton;

    @FindBy(xpath = "//div/div/div[5]")
    private WebElement sendMessage;

    public NewLetterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewLetterPage sendNewMessage(String email, String letterSubject, String letterText) {
        delay(1000);
        sendTo.sendKeys(email);
        subject.sendKeys(letterSubject);
        letterContent.sendKeys(letterText);
        sendButton.click();
        return new NewLetterPage(driver);
    }

    public String getSendMessage(){
        return sendMessage.getText();
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}