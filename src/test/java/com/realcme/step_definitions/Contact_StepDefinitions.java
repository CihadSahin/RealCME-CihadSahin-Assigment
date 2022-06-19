package com.realcme.step_definitions;

import com.realcme.pages.ContactPage;
import com.realcme.pages.HomePage;
import com.realcme.utilities.ConfigurationReader;
import com.realcme.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact_StepDefinitions {
    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get("https://www.healthcourse.com");

    }


    @When("user clicks on the contact module")
    public void user_click_on_the_contact_module() {
        homePage.contactModule.click();

    }


    @When("user enters name {string}")
    public void user_enters_name(String string) {
        js.executeScript("window.scrollBy(0,100)");
        contactPage.inputName.sendKeys(string);
    }


    @When("user enters company {string}")
    public void user_enters_company(String string) {
        js.executeScript("window.scrollBy(0,100)");
        if (!string.equals(""))
            contactPage.company.sendKeys(string);

    }


    @When("user enters email {string}")
    public void user_enters_email(String string) {
        js.executeScript("window.scrollBy(0,100)");
        if (!string.equals(""))
            contactPage.emailAddress.sendKeys(string);

    }


    @When("user should be able to write message {string}")
    public void user_should_be_able_to_write_message(String string) {
        js.executeScript("window.scrollBy(0,100)");
        if (!string.equals(""))
            contactPage.message.sendKeys(string);
    }


    @And("user enters phone number {string}")
    public void user_enters_phone_number(String string) {
        js.executeScript("window.scrollBy(0,100)");
        if (!string.equals(""))
            contactPage.phoneNumber.sendKeys(string);
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {

        //js.executeScript("arguments[0].scrollIntoView(true)",contactPage.submit);
        js.executeScript("window.scrollBy(0,300)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.getDriver().manage().deleteAllCookies();
        contactPage.submit.click();
        js.executeScript("window.scrollBy(0,-600)");
    }

    @Then("user sees the verify message {string}")
    public void user_sees_the_verify_message(String expectedMessage) {

        String actualMessage = "";
        if (expectedMessage.equals("Thank you for contacting HealthCourse. Your message has been received."))
            actualMessage = contactPage.verifyMessage.getText();
        else if (expectedMessage.equals("Please, fill in the following fields:"))
            actualMessage = contactPage.verifyFillTheFollowingFields.getText();
        else if (expectedMessage.equals("Invalid email"))
            actualMessage = contactPage.verifyInvalidEmailMessage.getText();
        else
            actualMessage=contactPage.verifyOnlyNumbersMessage.getAttribute("title");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedMessage,actualMessage);
    }


}
