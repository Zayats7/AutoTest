//package LoginPages;
//
//import Base.MailBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import java.util.logging.Logger;
//
//public class MailLoginPage extends MailBase {
//
//    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MailLoginPage.class));
//    private static final By LOGIN_BOX = By.xpath(".//input[contains(@name, 'login')]");
//    private static final By PASSWORD_BOX = By.xpath(".//input[contains(@name, 'password')]");
//    private static final String LOGIN = "margleibblan@mail.ru";
//    private static final String PASSWORD = "qwedcxzasdfghjkl;'\\";
//    private static final By CHECKBOX = By.xpath(".//input[contains(@type, 'checkbox')]");
//    private static final By GO_TO_PASSWORD = By.xpath(".//button[contains(@data-testid, 'enter-password')]");
//    private static final By GO_TO = By.xpath(".//button[contains(@data-testid, 'login-to-mail')]");
//    private static final By LOGIN_VISIBLE = By.name("login");
//    private static final By PASSWORD_VISIBLE = By.name("password");
//
//    public MailLoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public void doLogin() {
//        LOGGER.warning("Находим поле для ввода почты");
//        driver.findElement(LOGIN_BOX);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_VISIBLE));
//        LOGGER.info("Вводим почту");
//        driver.findElement(LOGIN_VISIBLE).sendKeys(LOGIN);
//    }
//
//    public void doCheckBox() {
//        LOGGER.warning("Проверяем видимость чекбокса'");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX));
//        LOGGER.info("Выключаем чекбокс 'Запомнить'");
//        driver.findElement(CHECKBOX).click();
//    }
//
//    public void doPassword() {
//        LOGGER.warning("Проверяем видимость кнопки для ввода пароля");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(GO_TO_PASSWORD));
//        LOGGER.info("Нажимаем на кнопку 'Ввести пароль'");
//        driver.findElement(GO_TO_PASSWORD).click();
//        LOGGER.warning("Находим поле для ввода пароля");
//        driver.findElement(PASSWORD_BOX);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_VISIBLE));
//        LOGGER.info("Вводим пароль");
//        driver.findElement(PASSWORD_VISIBLE).sendKeys(PASSWORD);
//    }
//
//    public void goToMainPage() {
//        LOGGER.warning("Проверяем видимость кнопки входа");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(GO_TO));
//        LOGGER.info("Нажимаем на кнопку входа");
//        driver.findElement(GO_TO).click();
//    }
//
//}