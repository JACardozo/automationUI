package org.personal.myStore.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.personal.myStore.core.pages.ContactUsPage;
import org.personal.myStore.core.pages.HeaderPage;
import org.testng.Assert;

public class ContactUsSteps {
    private HeaderPage headerPage = new HeaderPage();
    private ContactUsPage contactUsPage;

    public ContactUsSteps(HeaderPage headerPage) {
        this.headerPage = headerPage;
    }

    @Given("I went to {string} page")
    public void iWentToPage(String pageName) {
        contactUsPage = headerPage.navigateTo(pageName);
    }

    @When("I type {string} on email field under Contact us page")
    public void iTypeOnEmailFieldUnderContactUsPage(String emailAddress) {
        contactUsPage = contactUsPage.fillEmailAddressField(emailAddress);
    }

    @And("I press click on Send button")
    public void iPressClickOnSendButton() {
        contactUsPage = contactUsPage.clickOnSendBtn();
    }

    @Then("An Error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = contactUsPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "The error message is not than expected");
    }

    @When("I type {string} on message field under Contact us page")
    public void iTypeOnMessageFieldUnderContactUsPage(String messageText) {
        contactUsPage = contactUsPage.fillMessageText(messageText);
    }

    @When("I select {string} from select subject")
    public void iSelectFromSelectSubject(String subject) {
        contactUsPage = contactUsPage.selectSubject(subject);
    }

    @Then("The {string} message should be displayed")
    public void theMessageShouldBeDisplayed(String message) {
        String successMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(successMessage, message, "The message is not the expected");
    }
}
