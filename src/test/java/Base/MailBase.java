package Base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


public class MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MailBase.class));
    private static final String WEB_SITE = "https://mail.ru/";
    public WebDriver driver;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
     void startDriver() {
        LOGGER.info("Запускаем браузер");
        LOGGER.info("Переходим на страницу логина");
        Selenide.open(WEB_SITE);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    void killDriver() {
        LOGGER.info("Закрываем браузер");
        Selenide.closeWebDriver();
    }

}
