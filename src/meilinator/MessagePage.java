package meilinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
    private WebDriver driver;


    public MessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean isMessagePresent(String message)  {
        driver.switchTo().frame(driver.findElement(By.id("msg_body")));
        delay(2000);
        String s = driver.getPageSource();
        return s.contains(message);
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
