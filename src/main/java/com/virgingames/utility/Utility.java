package com.virgingames.utility;

import com.virgingames.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utility extends BasePage {

    /*
    * This class will stores and handles the functions (The code which is repetitive in nature such as waits, actions, capturing screenshots,
     accessing excels, sending email, etc.,) which can be commonly used across the entire framework.
     * The reason behind creating a utility class is to achieve reUsability.
     * This class extends the BasePage class to inherit the properties of BasePage in Utility.
     */

    //This method will click on element

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element) {

        element.click();
    }
    public void submitOnLoginButton(WebElement element){
        element.submit();
    }
    // This method will get text from element

    public String getTextFromElement(WebElement element) {
        //String text=driver.findElement(by).getText();// another way to write next line
        return element.getText();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    // This method will send text to element

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    public void sendTextToElement(WebElement element, String text) {

        element.sendKeys(text);
    }

    //This method will select the value from drop down

    public void selectByValueFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public <value> void selectByValueFromDropDown(By by, String value) {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //This method will select the visibility from dropdown

    public void selectByVisibleTextFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }
    //This will select the index from dropdown

    public void selectByIndexFromDropDown(WebElement element, int value) {
        Select select = new Select(element);
        select.selectByIndex(value);
    }

    public void selectByIndexFromDropDown(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);

    }

    // This method will mouse hover on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    //This method will mouse hover and click on element

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    //This method will clear the previous date

    public void clear(WebElement element) {
        element.clear();
    }

    public void clear(By by) {
        driver.findElement(by).clear();

    }

    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }
    //This method will create random email

    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);




    public <BY, attribute> String getAttributeFromElement(By by, String value) {
        return driver.findElement(by).getAttribute("value");

    }

    // This method will get the list of elements
    public List getListFromElements(By by) {
        return driver.findElements(by);

    }

    public List<WebElement> getListOfElements(List<WebElement> element) {

        return (List<WebElement>) element;
    }

     // This method will used to wait web driver until element become clickable

    public void waitUntilElementToBeClickable(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

     //This method will used to wait web driver until presence of element located by locator

    public void waitUntilPresenceOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
     // This method will used to wait web driver until visibility of element located by locator

    public void waitUntilVisibilityOfElementLocated(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
   //This method will get current timestamp

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/virgingames/screenshots" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element ,String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public void sendTabAndEnterKey(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }



}
