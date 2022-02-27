package TestsMail;

import Base.MailBase;
import LoginPages.NewMailLoginPage;
import MainPages.MailMainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.*;

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

//TODO разобраться с extends (сделать обертку браузера в отдельном классе) (Progress: 70%)
//TODO разобраться с аннотациями (Выкинуть их из теста) (Progress: 100%)
//TODO перевести тест на селенид (Progress: 100%)
//TODO перенести константы в аргументы метода, в следствии чего переписать класс логина (Progress: %)
public class TestSendMail extends MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestSendMail.class));
    private static final By CHECK_E_MAIL = By.xpath(".//*[contains(@class, 'email-block__inner-content')]");
    private static final String LOGIN = "margleibblan@mail.ru";
    private static final String PASSWORD = "qwedcxzasdfghjkl;'\\";

    @Test
    public void testSentMessage() {
        NewMailLoginPage loginPage = new NewMailLoginPage();
        LOGGER.info("Логин");
        loginPage.doLogin(LOGIN);
        loginPage.doCheckBox();
        LOGGER.info("Пароль");
        loginPage.doPassword(PASSWORD);
        LOGGER.info("Сравниваем введенный адрес почты и отображаемый");
        String compareEmail = $(CHECK_E_MAIL).getText();
        Assertions.assertEquals(LOGIN, compareEmail, "Логины не совпадают");
        LOGGER.info("Заходим в почту");
        loginPage.goToMainPage();

        MailMainPage mainPage = new MailMainPage();
        LOGGER.info("Написать письмо");
        mainPage.writeMessageButton();
        LOGGER.info("Выбираем адресата");
        mainPage.whomLine();
        mainPage.mySelfButton();
        LOGGER.info("Заполняем тему и пишем письмо");
        mainPage.topic();
        mainPage.texBox();
        LOGGER.info("Отправляем письмо");
        mainPage.sendMessageButton();
        Assertions.assertTrue(mainPage.sendMessageLayer().isDisplayed());
        LOGGER.warning("Письмо отправлено, тест пройден");
    }

}

