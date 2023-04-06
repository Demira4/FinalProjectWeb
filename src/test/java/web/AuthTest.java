package web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webPages.LoginPage;
import webPages.MyPostsPage;
import webPages.PostPage;

public class AuthTest extends AbstractTest {

    LoginPage loginPage;
    MyPostsPage myPostsPage;
    PostPage postPage;
    protected String username = "lol";
    protected String password = "9cdfb439c7";

    @BeforeEach
    void init() {
    loginPage = new LoginPage(getWebDriver());
    myPostsPage = new MyPostsPage(getWebDriver());
    postPage = new PostPage(getWebDriver());
}
    @Test
    @Story("Валидная авторизация")
    @DisplayName("1: Авторизация пользователя с валидными Логином 10 символов и валидным Паролем ")
    public void test1() throws InterruptedException {
        loginPage.loginIn("10simvolov","6f91ae8332");
        myPostsPage.checkChangeUrl();
    }

    @Test
    @Story("Валидная авторизация")
    @DisplayName("2: Авторизация пользователя с валидными Логином 3 символа и валидным Паролем ")
    public void test2() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.checkChangeUrl();
    }
    @Test
    @Story("Валидная авторизация")
    @DisplayName("3: Авторизация пользователя с валидными Логином 20 символов и валидным Паролем ")
    public void test3() throws InterruptedException {
        loginPage.loginIn("wertyujhg123fdsazx23","8f15c98096");
        myPostsPage.checkChangeUrl();
    }

    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("4: Авторизация пользователя с пустыми Логином и пустым Паролем ")
    public void test4() throws InterruptedException {
        loginPage.loginIn("","");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }
    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("5: Авторизация с невалидным Логином и валидным паролем")
    public void test5() throws InterruptedException {
        loginPage.loginIn("qwerty12", password);
        loginPage.checkUrl();//проверяем что остались на той же странице
    }
    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("6: Авторизация с невалидным логином 2 символа и валидным паролем")
    public void test6() throws InterruptedException {
        loginPage.loginIn("gg","73c18c59a3");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }
    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("7: Авторизация с невалидным логином 21 символ и валидным паролем")
    public void test7() throws InterruptedException {
        loginPage.loginIn("jhgfvbnjhf1234gfbch65","73c18c59a3");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }

    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("8: Авторизация с невалидным логином на русском языке и валидным паролем")
    public void test8() throws InterruptedException {
        loginPage.loginIn("Светлана","14fcb108d3");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }

    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("9: Авторизация с невалидным логином на рус+спецсимволы и валидным паролем")
    public void test9() throws InterruptedException {
        loginPage.loginIn("Свет1 @","052451ad17");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }

    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("10: Авторизация с невалидным логином на анг+спецсимволы и валидным паролем")
    public void test10() throws InterruptedException {
        loginPage.loginIn("F@ck2","e875c1b3ea");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }

}
