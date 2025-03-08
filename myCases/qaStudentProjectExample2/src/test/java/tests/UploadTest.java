package tests;

import com.herokuapp.pages.UploadPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UploadTest extends TestBase {

    private UploadPage uploadPage;

    @BeforeMethod
    public void setUpPage() {
        uploadPage = new UploadPage(app.getDriver());
        uploadPage.navigateToUploadPage();
    }

    @Test
    public void testFileUpload() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/sample.txt";

        uploadPage.uploadFile(filePath);

        String uploadedFileName = uploadPage.getUploadedFileName();

        assertEquals(uploadedFileName, "sample.txt", "Файл был загружен некорректно");
    }
}
