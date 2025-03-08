package tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.MultipleWindowsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(MultipleWindowsTest.class);
    private MultipleWindowsPage multipleWindowsPage;

    @BeforeMethod
    public void preCondition() {
        logger.info("Переход на страницу 'Multiple Windows'");

        HomePage homePage = new HomePage(app.getDriver());
        homePage.clickLinkByText("Multiple Windows");

        multipleWindowsPage = new MultipleWindowsPage(app.getDriver());
    }

    @Test
    public void testNewWindow() {
        logger.info("Начинаем тест на открытие нового окна");

        logger.debug("Клик по ссылке 'Click Here'");
        multipleWindowsPage.clickClickHereLink();

        logger.info("Переключаемся на новое окно");
        multipleWindowsPage.switchToNewWindow();

        logger.info("Проверяем наличие текста 'New Window' на новой странице");
        String pageSource = app.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("New Window"), "Текст 'New Window' не найден на новой странице");

        logger.info("Тест на открытие нового окна успешно завершён");
    }
}
