package iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class HomeIUAPage {
    private WebDriver driver;

    @FindBy(xpath = "//p/a")
    private WebElement createLetter;


    public HomeIUAPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewLetterPage goToCreateNewLetter() {
        createLetter.click();
        return new NewLetterPage(driver);
    }
    public  boolean isElementСreateLetterPresent(){
        try {
            createLetter.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

}
