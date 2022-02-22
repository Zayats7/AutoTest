package Base;

import TestsMail.TestSendMail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestSendMail.class));
    private static final String WEB_SITE = "https://mail.ru/";
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        driver.get(WEB_SITE);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    void killDriver() {
        LOGGER.info("Закрываем браузер");
        driver.close();
    }

}
