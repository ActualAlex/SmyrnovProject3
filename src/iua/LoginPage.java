package iua;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "pass")
    private WebElement passwordField;

    @FindBy(xpath = "//form/p/input")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/form/div/div[1]")
    private WebElement loginMessage;

    public String getLoginMessage(){
        return loginMessage.getText();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomeIUAPage loginToIUa(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomeIUAPage(driver);
    }


}
