package LoginPages;

import TestsMail.TestSendMail;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewMailLoginPage {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(NewMailLoginPage.class));
    private static final By LOGIN_BOX = By.xpath(".//input[contains(@name, 'username')]");
    private static final By BUTTON_TO = By.xpath(".//button[contains(@data-testid, 'enter-mail-primary')]");
    private static final By PASSWORD_BOX = By.xpath(".//*[contains(@name, 'password')]");
    private static final By CHECKBOX = By.xpath(".//*[contains(@class, 'box-0-2-111 activeBox-0-2-116')]");
    private static final By GO_TO_PASSWORD = By.xpath(".//button[contains(@data-test-id, 'next-button')]");
    private static final By GO_TO = By.xpath(".//button[contains(@data-test-id, 'submit-button')]");
    private static final By LOGIN_FRAME = By.xpath("//iframe[contains(@class, 'ag-popup__frame__layout__iframe')]");
    private static final By LOGIN_CONTENT = By.xpath(".//div[contains(@id, 'login-content')]");
    private static final By CHECK_E_MAIL = By.xpath(".//*[contains(@class, 'email-block__inner-content')]");

    public void doLogin(String login) {
        LOGGER.warning("Находим кнопку для ввода логина и кликаем на нее");
        $(BUTTON_TO).shouldHave(text("Войти")).click();
        LOGGER.info("Переключаемся во фрейм формы логина");
        $(LOGIN_FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(LOGIN_FRAME).shouldBe(visible));
        LOGGER.warning("Ждем появления формы логина");
        $(LOGIN_CONTENT).shouldBe(visible);
        LOGGER.info("Находим поле для ввода почты и вводим почту");
        $(LOGIN_BOX).shouldBe(visible).sendKeys(login);
    }

    public void doCheckBox() {
        LOGGER.warning("Проверяем видимость чекбокса и выключаем его");
        $(CHECKBOX).shouldBe(visible).click();
    }

    public void doPassword(String password) {
        LOGGER.warning("Проверяем видимость кнопки для ввода пароля и кликаем на нее");
        $(GO_TO_PASSWORD).shouldBe(visible).click();
        LOGGER.info("Сравниваем введенный адрес почты и отображаемый");
        String compareEmail = $(CHECK_E_MAIL).getText();
        Assertions.assertEquals(TestSendMail.LOGIN, compareEmail, "Логины не совпадают");
        LOGGER.info("Находим поле для ввода пароля и вводим пароль");
        $(PASSWORD_BOX).shouldBe(visible).sendKeys(password);
    }

    public void goToMainPage() {
        LOGGER.warning("Проверяем видимость кнопки входа и заходим в аккаунт");
        $(GO_TO).shouldBe(visible).click();
    }
}
