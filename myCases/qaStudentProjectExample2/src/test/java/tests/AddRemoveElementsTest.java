package tests;

import com.herokuapp.pages.AddRemoveElementsPage;
import com.herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends TestBase {

    private HomePage homePage;
    private AddRemoveElementsPage addRemoveElementsPage;

    @BeforeMethod
    public void preconditions() {
        homePage = new HomePage(app.getDriver());
        homePage.clickLink("Add/Remove Elements");

        addRemoveElementsPage = new AddRemoveElementsPage(app.getDriver());
    }

    @Test
    public void testAddElement() {
        addRemoveElementsPage.clickAddElementButton();
        int deleteButtonCount = addRemoveElementsPage.getDeleteButtonCount();

        Assert.assertEquals(deleteButtonCount, 1, "Количество кнопок 'Delete' должно быть 1 после добавления");
    }

    @Test
    public void testAddMultipleElements() {
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();

        int deleteButtonCount = addRemoveElementsPage.getDeleteButtonCount();
        Assert.assertEquals(deleteButtonCount, 3, "Количество кнопок 'Delete' должно быть 3 после добавления трёх элементов");
    }

    @Test
    public void testDeleteElement() {
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();
        Assert.assertEquals(addRemoveElementsPage.getDeleteButtonCount(), 2, "Должно быть 2 кнопки 'Delete' перед удалением");

        addRemoveElementsPage.clickDeleteButton(0);
        int deleteButtonCountAfterDeletion = addRemoveElementsPage.getDeleteButtonCount();
        Assert.assertEquals(deleteButtonCountAfterDeletion, 1, "Количество кнопок 'Delete' должно быть 1 после удаления");
    }
}
