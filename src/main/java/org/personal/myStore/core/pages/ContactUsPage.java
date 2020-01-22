package org.personal.myStore.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.personal.myStore.core.ui.AbstractPage;

public class ContactUsPage extends AbstractPage {

    @FindBy(css = "h1.page-heading")
    private WebElement contactTitle;

    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(css = "button#submitMessage")
    private WebElement sendBtn;

    @FindBy(css = "textarea#message")
    private WebElement textArea;

    @FindBy(css = "div#uniform-id_contact")
    private WebElement subjectSelect;

    private final String errorMessageCssSelector = "div.alert-danger li";
    private final String selectMenuCssSelector = "select#id_contact";
    private final String successMessageCssSelector = "p.alert-success";

    public ContactUsPage() {
        action.waitVisibility(contactTitle);
    }

    public ContactUsPage fillEmailAddressField(String emailAddress) {
        emailField.sendKeys(emailAddress);
        return this;
    }

    public ContactUsPage clickOnSendBtn() {
        action.click(sendBtn);
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector(errorMessageCssSelector)).getText();
    }

    public ContactUsPage fillMessageText(String messageText) {
        textArea.sendKeys(messageText);
        return this;
    }

    public ContactUsPage selectSubject(String subject) {
        action.click(subjectSelect);
        WebElement subjectSelected = driver.findElement(By.cssSelector(selectMenuCssSelector))
                .findElement(By.xpath("//option[text()='"+subject+"']"));
        action.click(subjectSelected);
        return this;
    }

    public String getSuccessMessage() {
        By cssSelector = By.cssSelector(successMessageCssSelector);
        action.waitVisibility(cssSelector);
        return driver.findElement(cssSelector).getText();
    }
}
