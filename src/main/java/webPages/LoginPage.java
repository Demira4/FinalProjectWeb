package webPages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {// наследуемся

    public LoginPage(WebDriver driver) {// создаем конструктор
        super(driver);
    }

    @FindBy(xpath = "//input[@type=\"text\"]")// поле username
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type=\"password\"]")// поле password
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class=\"mdc-button__label\"]")// кнопка зарегистрироваться
    private WebElement loginButton;

   @Step ("Авторизация пользователя")
    public MyPostsPage loginIn(String login, String password) throws InterruptedException {// на вход передаем логин и пароль для позитивного теста
        // метод для регистрации( включает все действия)- для негативных сценариев каждое действие в отдельный метод
        usernameField.click();
        usernameField.sendKeys(login);// вбиваем логин
        passwordField.click();
        passwordField.sendKeys(password);//вбиваем пароль
        loginButton.click();//кликаем
        Thread.sleep(3000);
        return new MyPostsPage(driver);
    }
    @Step("Заполняем поле Username")
    public LoginPage inputLogin (String login){
        usernameField.click();
        usernameField.sendKeys(login);
        return this;
    }
    @Step("Заполняем поле Password")
    public LoginPage inputPassword(String password){
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }
    @Step("Кликаем на кнопку Login")
    public MyPostsPage clickLogin() throws InterruptedException {
        loginButton.click();
//        Thread.sleep(2000);
        return new MyPostsPage(driver);
    }

    @Step("Проверяем что остались на той же странице(по url)")
    public void checkUrl(){
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

}

