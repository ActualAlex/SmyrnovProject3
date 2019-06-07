package meilinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table/tbody/tr[1]//td[3]")
    private WebElement senderField;


    @FindBy(xpath = "//table/tbody/tr[1]//td[4]")
    private WebElement subjectField;

    @FindBy(xpath = "//table/tbody/tr[1]//td[4]")
    private WebElement letterButton;

    public String getSenderText(){
        return senderField.getText();
    }
    public String getSubjectText(){
        return subjectField.getText();
    }

    public MessagePage toNewMail(){
        letterButton.click();
        return new MessagePage(driver);
    }
}
