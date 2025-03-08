package tests;

import com.herokuapp.pages.DropdownPage;
import com.herokuapp.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownTest extends TestBase {
    private DropdownPage dropdownPage;
    private static final Logger logger = LoggerFactory.getLogger(DropdownTest.class);

    @BeforeMethod
    public void preCondition() {
        logger.info("Переход на страницу 'Dropdown' через HomePage");
        HomePage homePage = new HomePage(app.getDriver());

        WebDriverWait wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(10));
        wait.until(webDriver -> homePage.isLinkPresent("Dropdown"));

        homePage.clickLinkByText("Dropdown");

        dropdownPage = new DropdownPage(app.getDriver());

        logger.info("Страница 'Dropdown' успешно открыта и инициализирована");
    }

    @Test
    public void testSelectOption1() {
        logger.info("Начинаем тест: выбор 'Option 1' в раскрывающемся списке");

        dropdownPage.selectOptionByVisibleText("Option 1");

        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, "Option 1", "Неправильно выбран элемент в раскрывающемся списке");

        logger.info("Тест завершен успешно: 'Option 1' был правильно выбран");
    }

    @Test
    public void testSelectOption2() {
        logger.info("Начинаем тест: выбор 'Option 2' в раскрывающемся списке");

        dropdownPage.selectOptionByVisibleText("Option 2");

        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, "Option 2", "Неправильно выбран элемент в раскрывающемся списке");

        logger.info("Тест завершен успешно: 'Option 2' был правильно выбран");
    }
}
