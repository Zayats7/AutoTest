package TestsMail;

import LoginPages.NewMailLoginPage;
import MainPages.MailMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Logger;

/**
 * Тест проверяет логин и отправку письма самому себе
 * 1. Залогиниться пользователем
 * 2. Открыть леер сообщений
 * 3. Выбрать в адресате себя
 * 4. Заполнить тему
 * 5. Заполнить само сообщение
 * 6. Отправить сообшение
 * 7. Проверить что сообщение отправлено
 */
public class TestSendMail {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestSendMail.class));
    private static final String WEB_SITE = "https://mail.ru/";
      WebDriver driver = new ChromeDriver();

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        LOGGER.info("Открываем начальную страницу");
        driver.get(WEB_SITE);
    }

    @Test
    public void testSentMessage() {
        NewMailLoginPage loginPage = new NewMailLoginPage(driver);
        LOGGER.info("Запускаем браузер");
        driver.get(WEB_SITE);
        LOGGER.info("Логин");
        loginPage.doLogin();
        loginPage.doCheckBox();
//        TODO реализовать проверку валидности почты
//        LOGGER.info("Сравниваем введенный адрес почты и отображаемый");
        //String emailInfo = driver.findElement(CHECK_E_MAIL).getAttribute(CHECK_E_MAIL);
//        Assertions.assertTrue(emailInfo.contains(LOGIN));
        LOGGER.info("Пароль");
        loginPage.doPassword();
        LOGGER.info("Заходим в почту");
        loginPage.goToMainPage();

        MailMainPage mainPage = new MailMainPage(driver);
        LOGGER.info("Написать письмо");
        mainPage.writeMessageButton();
        mainPage.messageLayer();
        LOGGER.info("Выбираем адресата");
        mainPage.whomLine();
        mainPage.quickPeople();
        mainPage.mySelfButton();
        LOGGER.info("Заполняем тему и пишем пьсьмо");
        mainPage.topic();
        mainPage.texBox();
        LOGGER.info("Отправляем письмо");
        mainPage.sendMessageButton();
        Assertions.assertTrue(mainPage.sendMessageLayer().isDisplayed());
        LOGGER.warning("Письмо отправлено, тест пройден");
    }

    @AfterEach
    void killDriver() {
        LOGGER.info("Закрываем браузер");
        driver.quit();
    }

}

