package MainPages;

import Base.MailBase;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import java.util.logging.Logger;

public class MailMainPage extends MailBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MailMainPage.class));
    private static final By WRITE_MESSAGE = By.xpath(".//a[contains(@title, 'Написать письмо')]");
    private static final By MESSAGE_LAYER = By.xpath(".//div[contains(@class, 'compose-app__compose')]");
    private static final By WHOM = By.xpath(".//div[contains(@data-type, 'to')]");
    private static final By FAST_MESSAGE_LAYER = By.xpath(".//div[contains(@class, 'datalist--3ogk- datalist_visible--3Ip9Z datalist_show--2PGmR fadeInUp--2yJ0y')]");
    private static final By MYSELF_MESSAGE = By.xpath(".//div[contains(@data-test-id, 'letter-to-yourself')]");
    private static final By TOPIC = By.xpath(".//input[contains(@name, 'Subject')]");
    private static final By TEXT_BOX = By.xpath(".//div[contains(@role, 'textbox')]");
    private static final By SENT_BUTTON = By.xpath(".//span[contains(@data-title-shortcut, 'Cmd+Enter')]");
    private static final By SEND_MESSAGE_LAYER = By.xpath(".//*[contains(@class, 'layer__link')]");

    public MailMainPage(WebDriver driver) {
        super(driver);
    }

    public void writeMessageButton() {
        LOGGER.warning("Проверяем видимость кнопки создания нового сообщения и кликаем на нее");
        $(WRITE_MESSAGE).shouldBe(visible).click();
//        LOGGER.warning("Проверяем видимость леера сообщения");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WRITE_MESSAGE));
//        LOGGER.info("Нажимаем на кнопку 'Написать письмо'");
//        driver.findElement(WRITE_MESSAGE).click();
    }

    public void messageLayer() {
        LOGGER.warning("Ждем появления леера письма");
        $(MESSAGE_LAYER).shouldBe(visible);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_LAYER));
    }

    public void whomLine() {
        LOGGER.warning("Проверяем видимость поля адресата и кликаем на него");
        $(WHOM).shouldBe(visible).click();
//        LOGGER.warning("Проверяем видимость поля адресата");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WHOM));
//        LOGGER.info("Кликаем на поле 'Кому'");
//        driver.findElement(WHOM).click();
    }

    public void quickPeople() {
        LOGGER.warning("Ждем видимость леера быстрых адресатов");
        $(FAST_MESSAGE_LAYER).shouldBe(visible);
//        LOGGER.warning("Ждем видимость леера быстрых адресатов");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FAST_MESSAGE_LAYER));
    }

    public void mySelfButton() {
        LOGGER.warning("Прверяем видимость себя в списке адресатов и кликаем");
        $(MYSELF_MESSAGE).shouldBe(visible).click();
//        LOGGER.warning("Прверяем видимость себя в списке адресатов");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MYSELF_MESSAGE));
//        LOGGER.info("Кликаем на 'Отправить себе'");
//        driver.findElement(MYSELF_MESSAGE).click();
    }

    public void topic() {
        LOGGER.warning("Проверяем видимость поля темы и вводим сообщение");
        $(TOPIC).shouldBe(visible).sendKeys("Test");
//        LOGGER.warning("Проверяем видимость поля темы");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(TOPIC));
//        LOGGER.info("В теме вводим сообщение");
//        driver.findElement(TOPIC).sendKeys("Test");
    }

    public void texBox() {
        LOGGER.warning("Проверяем видимость поля ввода сообщения и вводим сообщение");
        $(TEXT_BOX).shouldBe(visible).sendKeys("Hello world it's test!");
//        LOGGER.warning("Проверяем видимость поля ввода сообщения");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_BOX));
//        LOGGER.info("Вводим сообщение в основном поле для ввода сообщения");
//        driver.findElement(TEXT_BOX).sendKeys("Hello world it's test!");
    }

    public void sendMessageButton() {
        LOGGER.warning("Проверяем видимость кнопки отправки и кликаем");
        $(SENT_BUTTON).shouldBe(visible).click();
//        LOGGER.warning("Проверяем видимость кнопки отправки");
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SENT_BUTTON));
//        LOGGER.info("Нажимаем 'Отправить'");
//        driver.findElement(SENT_BUTTON).click();
    }

    public SelenideElement sendMessageLayer() {
        LOGGER.warning("Проверяем отображение подтверждения отправки сообщения");
        return $(SEND_MESSAGE_LAYER).shouldBe(visible);
//        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SEND_MESSAGE_LAYER));

    }

}
