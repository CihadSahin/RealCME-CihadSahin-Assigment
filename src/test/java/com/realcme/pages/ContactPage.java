package com.realcme.pages;

import com.realcme.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    public ContactPage(){PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(css = "input[id='et_pb_contact_name_0']")
    public WebElement inputName;


    @FindBy(xpath = "(//input[@class='input'])[2]")
    public WebElement company;

    @FindBy(css = "input[id='et_pb_contact_email_0']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@title='Only numbers allowed.']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//textarea[@placeholder='Message']")
    public WebElement message;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//p[.='Thank you for contacting HealthCourse. Your message has been received.']")
    public WebElement verifyMessage;

    @FindBy(xpath = "//li[normalize-space()='Invalid email']")
    public WebElement verifyInvalidEmailMessage;

    @FindBy(xpath = "//input[@placeholder='Phone Number']\n")
    public WebElement verifyOnlyNumbersMessage;

    @FindBy(xpath = "//p[normalize-space()='Please, fill in the following fields:']")
    public WebElement verifyFillTheFollowingFields;

}
