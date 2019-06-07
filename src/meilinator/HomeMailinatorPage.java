package meilinator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomeMailinatorPage {


    private WebDriver driver;

    public HomeMailinatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inboxfield")
    private WebElement inboxField;

    @FindBy(xpath = "//span/button")
    private WebElement searchButton;


    public InboxPage findNewLetter(String email){
    inboxField.click();
    inboxField.sendKeys(email);
    searchButton.click();
    return new InboxPage(driver);
    }




}
