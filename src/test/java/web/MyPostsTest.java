package web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webPages.LoginPage;
import webPages.MyPostsPage;
import webPages.PostPage;

public class MyPostsTest extends AbstractTest {
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
    @Story("Лента своих постов")
    @DisplayName("1: Переход к следущей странице в ленте своих постов")
    public void test1() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.toNextPage();
        myPostsPage.checkToNextPage();
    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("2: У превью поста отображается картинка, заголовок и описание")
    public void test2() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.checkPosts();

    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("3: Переход на предыдущую страницу ленты своих постов ")
    public void test3() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.moveToPreviousPage();
        myPostsPage.checkMoveToPreviousPage();

    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("4: Переход на страницу конкретного поста ")
    public void test4() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.clickPost();
        postPage.checkMoveToPostPage();

    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("5: Сортировка постов от старых к новым и наоборот")
    public void test5() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.clickOrder();
        myPostsPage.checkOrderDESC();
        myPostsPage.clickOrderOn();
        myPostsPage.checkOrderASC();

    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("6: Переход к странице чужих постов")
    public void test6() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.moveNotMyPostsPage();
        myPostsPage.checkMoveNotMyPostsPage();
    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("7: Переход к домашней странице")
    public void test7() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.moveNotMyPostsPage();
        myPostsPage.moveToHomePage();
        myPostsPage.checkMoveToHomePage();
    }


}
