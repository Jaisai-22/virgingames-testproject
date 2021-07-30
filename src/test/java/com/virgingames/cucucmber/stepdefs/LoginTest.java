package com.virgingames.cucucmber.stepdefs;

import com.virgingames.pages.HomePage;
import com.virgingames.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

//Here we actually write a selenium script to carry out the test under Cucumber methods.
public class LoginTest {


    @Given("^I am home page$")
    public void iAmHomePage() {
    }

    @When("^I click on login link$")
    public void iClickOnLoginLink() {
        new HomePage().clickOnOkPopUpButton();
        new HomePage().clickOnLoginTab();
    }

    @Then("^I should navigate to login page$")
    public void iShouldNavigateToLoginPage() {

        String actualMessage = new LoginPage().verifyPageNavigation();
        Assert.assertTrue(actualMessage.contains("GAMES"));
    }

    @And("^I enter invalid email \"([^\"]*)\"$")
    public void iEnterInvalidEmail(String email) {

        new LoginPage().enterEmailId(email);
    }

    @And("^I enter invalid password \"([^\"]*)\"$")
    public void iEnterInvalidPassword(String password) {

        new LoginPage().enteringPassword(password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();

    }

    @Then("^I should see the error message \"([^\"]*)\"$")
    public void iShouldSeeTheErrorMessage(String errorMessage) {

        new LoginPage().verifyErrorMessageDisplayed(errorMessage);
        new LoginPage().verifyErrorMessageDisplayedwithEmptyField(errorMessage);
    }


}
