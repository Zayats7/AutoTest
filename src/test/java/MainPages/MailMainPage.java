package MainPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import java.util.logging.Logger;

public class MailMainPage {

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

    public void writeMessageButton() {
        LOGGER.warning("Проверяем видимость кнопки создания нового сообщения и кликаем на нее");
        $(WRITE_MESSAGE).shouldBe(visible).click();
    }

    public void whomLine() {
        LOGGER.warning("Проверяем видимость поля адресата и кликаем на него");
        $(WHOM).shouldBe(visible).click();
    }

    public void mySelfButton() {
        LOGGER.warning("Прверяем видимость себя в списке адресатов и кликаем");
        $(MYSELF_MESSAGE).shouldBe(visible).click();
    }

    public void topic() {
        LOGGER.warning("Проверяем видимость поля темы и вводим сообщение");
        $(TOPIC).shouldBe(visible).sendKeys("Test");
    }

    public void texBox() {
        LOGGER.warning("Проверяем видимость поля ввода сообщения и вводим сообщение");
        $(TEXT_BOX).shouldBe(visible).sendKeys("Hello world it's test!");
    }

    public void sendMessageButton() {
        LOGGER.warning("Проверяем видимость кнопки отправки и кликаем");
        $(SENT_BUTTON).shouldBe(visible).click();
    }

    public SelenideElement sendMessageLayer() {
        LOGGER.warning("Проверяем отображение подтверждения отправки сообщения");
        return $(SEND_MESSAGE_LAYER).shouldBe(visible);
    }

}
