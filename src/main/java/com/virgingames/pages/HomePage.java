package com.virgingames.pages;

import com.cucumber.listener.Reporter;
import com.virgingames.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/* Homepage extends to Utility for the methods that needs to be performed.
 * Listing all the elements through their locators
 */

public class HomePage extends Utility {
    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs
     * Using selenium @Findby and initElement methods for locators/elements
     * Creating methods applicable to various locators
     */

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginLink;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okButton;

    //This method will click on okay button to accept cookies

    public void clickOnOkPopUpButton() {

        clickOnElement(okButton);
        log.info("Clicking on okay button" + okButton.toString());
    }
    //This method will click on Login Link
    public void clickOnLoginTab() {

        mouseHoverToElementAndClick(loginLink);
        log.info("Clicking on LoginLink: " + loginLink.toString());


    }

}
