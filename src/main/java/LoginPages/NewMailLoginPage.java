package LoginPages;

import Base.MailBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.Selenide;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewMailLoginPage extends MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MailLoginPage.class));
    private static final By LOGIN_BOX = By.xpath(".//input[contains(@name, 'username')]");
    private static final By BUTTON_TO = By.xpath(".//button[contains(@data-testid, 'enter-mail-primary')]");
    private static final By PASSWORD_BOX = By.xpath(".//*[contains(@name, 'password')]");
    private static final String LOGIN = "margleibblan@mail.ru";
    private static final String PASSWORD = "qwedcxzasdfghjkl;'\\";
    private static final By CHECKBOX = By.xpath(".//*[contains(@class, 'box-0-2-111 activeBox-0-2-116')]");
    private static final By GO_TO_PASSWORD = By.xpath(".//button[contains(@data-test-id, 'next-button')]");
    private static final By GO_TO = By.xpath(".//button[contains(@data-test-id, 'submit-button')]");
    private static final By LOGIN_FRAME = By.xpath("//iframe[contains(@class, 'ag-popup__frame__layout__iframe')]");
    private static final By LOGIN_CONTENT = By.xpath(".//div[contains(@id, 'login-content')]");


    public NewMailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin() {
        LOGGER.warning("Находим кнопку для ввода логина и кликаем на нее");
        $(BUTTON_TO).shouldHave(text("Войти")).click();
        LOGGER.info("Переключаемся во фрейм формы логина");
        $(LOGIN_FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(LOGIN_FRAME).shouldBe(visible));
        LOGGER.warning("Ждем появления формы логина");
        $(LOGIN_CONTENT).shouldBe(visible);
        LOGGER.info("Находим поле для ввода почты и вводим почту");
        $(LOGIN_BOX).shouldBe(visible).sendKeys(LOGIN);
//        LOGGER.warning("Находим кнопку для ввода логина");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_TO));
//        LOGGER.info("Кликаем на кнопку для перехода к полю ввода логина");
//        driver.findElement(BUTTON_TO).click();
//        LOGGER.warning("Ждем появления формы логина");
//        driver.switchTo().frame(driver.findElement(LOGIN_FRAME));
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@id, 'login-content')]")));
//        LOGGER.warning("Находим поле для ввода почты");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BOX));
//        LOGGER.info("Вводим почту");
//        driver.findElement(LOGIN_BOX).sendKeys(LOGIN);
    }

    public void doCheckBox() {
        LOGGER.warning("Проверяем видимость чекбокса и выключаем его");
        $(CHECKBOX).shouldBe(visible).click();
//        LOGGER.warning("Проверяем видимость чекбокса'");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX));
//        LOGGER.info("Выключаем чекбокс 'Запомнить'");
//        driver.findElement(CHECKBOX).click();
    }

    public void doPassword() {
        LOGGER.warning("Проверяем видимость кнопки для ввода пароля и кликаем на нее");
        $(GO_TO_PASSWORD).shouldBe(visible).click();
        LOGGER.info("Находим поле для ввода пароля и вводим пароль");
        $(PASSWORD_BOX).shouldBe(visible).sendKeys(PASSWORD);
//        LOGGER.warning("Проверяем видимость кнопки для ввода пароля");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(GO_TO_PASSWORD));
//        LOGGER.info("Нажимаем на кнопку 'Ввести пароль'");
//        driver.findElement(GO_TO_PASSWORD).click();
//        LOGGER.warning("Находим поле для ввода пароля");
//        driver.findElement(PASSWORD_BOX);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_VISIBLE));
//        LOGGER.info("Вводим пароль");
//        driver.findElement(PASSWORD_VISIBLE).sendKeys(PASSWORD);
    }

    public void goToMainPage() {
        LOGGER.warning("Проверяем видимость кнопки входа и заходим в аккаунт");
        $(GO_TO).shouldBe(visible).click();
//        LOGGER.warning("Проверяем видимость кнопки входа");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(GO_TO));
//        LOGGER.info("Нажимаем на кнопку входа");
//        driver.findElement(GO_TO).click();
    }
}
