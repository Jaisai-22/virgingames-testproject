package com.virgingames.pages;

import com.virgingames.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/* LoginPage extends to Utility for the methods that needs to be performed.
 * Listing all the elements through their locators
 */

public class LoginPage extends Utility {
    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs
     * Using selenium @Findby and initElement methods for locators/elements
     * Creating methods applicable to various locators
     */

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    //locating login page navigation

    @FindBy(xpath = "//div[@class='logo-container']//a[@title='Virgin Games Home']//*[local-name()='svg']")
    WebElement verifyPageNavigation;

    // locating emailField webElement for sending text

    @FindBy(xpath = "//input[@id='field-username']")
    WebElement emailField;

    // locating password webElement for sending text

    @FindBy(xpath = "//input[@id='field-password']")
    WebElement passWordField;

    // locating loginBtn webElement to click

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    //  locating errorMessage with inputting both invalid data

    @FindBy(xpath = "//div[contains(text(),'Please try again, your username/email or password ')]")
    WebElement errorMessageForInvalidData;

    //locating errorMessage with both credential field empty
    @FindBy(xpath = "//div[contains(text(),'Both your username and password are required')]")
    WebElement errorMessageForEmptyField;


    //Method for verifying page navigation
    public String verifyPageNavigation() {
        log.info("Verify user navigate to login page: " + verifyPageNavigation.toString());
        return getTextFromElement(verifyPageNavigation);
    }


    //Method for entering email to email field
    public void enterEmailId(String email) {
        clickOnElement(emailField);
        sendTextToElement(emailField, email);
        log.info("Entering Email address " + email + "to email field: " + emailField.toString() + "<br>");
    }

    //Method for entering password in to password field
    public void enteringPassword(String password) {
        clickOnElement(passWordField);
        sendTextToElement(passWordField, password);
        log.info("Entering password : " + password + "to password field: " + passWordField.toString() + "<br>");
    }

    // Method for clicking on Login Button
    public void clickOnLoginButton() {
        log.info("Clicking on Login Button: " + loginBtn.toString() + "<br>");
        submitOnLoginButton(loginBtn);

    }
    // Method for getting error message with invalid credential

    public String getErrorMessage() {
        log.info("Getting error message from: " + errorMessageForInvalidData.toString());
        return getTextFromElement(errorMessageForInvalidData);

    }

    public void verifyErrorMessageDisplayed(String message) {
        log.info("Verify the error mesage is displayed correctly: " + errorMessageForInvalidData.toString());
        verifyThatTextIsDisplayed(errorMessageForInvalidData, message);

    }

    //Method for getting error message for both credential
    public String getErrorMessageForBothCredentialEmpty() {
        log.info("Getting error message from: " + errorMessageForEmptyField.toString());
        return getTextFromElement(errorMessageForEmptyField);

    }

    public void verifyErrorMessageDisplayedwithEmptyField(String message) {
        log.info("Verify that error message is displayed correctly with empty field " + errorMessageForEmptyField.toString());
        verifyThatTextIsDisplayed(errorMessageForEmptyField, message);

    }


}
