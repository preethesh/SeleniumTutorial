package com.selenium.screens;

import com.selenium.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

//import static com.selenium.BaseClass.findElementByNameAndClick;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.selenium.BaseClass.*;


/**
 * Created by joe on 7/9/2018.
 */
public class RegistrationScreen {

    public  static String INVALID_EMAIL_ADDRESS[] = { "text",
    "@gmail.com",
    };

    public static void tapOnHereLinkInLoginScreen(){

        Assert.assertTrue(BaseClass.findElementByLinkTextAndClick("here"), "Element not found");

    }
    public static void EnterDetailsInLoginScreen(Object text, String textField) {

        switch(textField) {

            case "User name":
                WebElement userIdElement = driver.findElement(By.name("uid"));
                userIdElement.click();
                userIdElement.sendKeys(text.toString());
                System.out.println(text);
                break;

            case "Password":
                WebElement passwordElement = driver.findElement(By.name("password"));
                passwordElement.click();
                passwordElement.sendKeys(text.toString());;
                break;
        }
    }

    public static LinkedHashMap<String, Object> getEmailAddressANdPassword() {

        List<WebElement> totalTableRowsList = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
        LinkedHashMap<String, Object> userNameAndPassword = new LinkedHashMap<>();
        System.out.println(totalTableRowsList.size());
        for(int i=0; i<totalTableRowsList.size(); i++) {

            WebElement element = totalTableRowsList.get(i);
            int size = element.findElements(By.tagName("td")).size();
            if(size==2){
                List<WebElement> tableColumnList = element.findElements(By.tagName("td"));
                WebElement uName = tableColumnList.get(0);
                String userName = uName.getText();
                WebElement pWord = tableColumnList.get(1);
                String password = pWord.getText();
                System.out.println(password);
                userNameAndPassword.put(userName, password);
            }
        }

        return userNameAndPassword;
    }


    public static void checkRegistrationScreenIsDisplayed(){
        Assert.assertTrue(isElementDisplayedByClassName("barone"));
    }

    public static void enterDetailsInEmailField(){
        Assert.assertTrue(sendTextByName("emailid", "joe.preethesh29@gmail.com"), "Element not found");
    }

    public static void enterDetailsInPasswordField() {
        Assert.assertTrue(sendTextByName("password", "9yhyzUh"), "Element not found");
    }

    public static void checkEmailIdThrowInvalidEmailIdFormat(){
        for(int index = 0; index < INVALID_EMAIL_ADDRESS.length; index++) {
            Assert.assertTrue(sendTextByName("emailid", INVALID_EMAIL_ADDRESS[index]));
            Assert.assertTrue(isErrorTextDisplayed("message9"), "error message should be displayed");
        }
    }

    public static HashMap<String, Object> tapOnSubmitButton(){
        Assert.assertTrue(findElementByNameAndClick("btnLogin"), "Submit button should be displayed");
        return getEmailAddressANdPassword();
    }

    public static void tapOnLoginButton() {
        Assert.assertTrue(findElementByNameAndClick("btnLogin"), "Login button should be displayed");
    }

}
