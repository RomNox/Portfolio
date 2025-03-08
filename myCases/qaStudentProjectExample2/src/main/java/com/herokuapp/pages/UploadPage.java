package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends BasePage {

    @FindBy(id = "file-upload")
    private WebElement uploadInput;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToUploadPage() {
        clickLinkByText("File Upload");
    }

    public void uploadFile(String filePath) {
        uploadInput.sendKeys(filePath);
        uploadButton.click();
    }

    public String getUploadedFileName() {
        return uploadedFiles.getText();
    }
}
