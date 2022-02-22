package Base;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codeborne.selenide.Selenide;

import java.time.Duration;

public class MailBase {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public MailBase(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

}
