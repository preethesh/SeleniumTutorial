package com.selenium.test;

import com.selenium.BaseClass;
import com.selenium.screens.RegistrationScreen;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

/**
 * Created by joe on 7/26/2018.
 */
public class DataDrivenTesting extends BaseClass {

    @Test(dataProvider = "test")
    public void testingDataDriven(String userName, String Password) throws InterruptedException {

        driver.findElement(By.id("user_login")).sendKeys(userName);
        driver.findElement(By.id("user_pass")).sendKeys(Password);
        driver.findElement(By.id("wp-submit")).click();
        Thread.sleep(5000);

    }

    @DataProvider(name = "test")
    public Object[][] passData() {

        Object[][] data = new Object[3][2];

        data[0][0] = "admin1";
        data[0][1] = "demo1";

        data[1][0] = "admin";
        data[1][1] = "test@123.com";

        data[2][0] = "admin2";
        data[2][1] = "demo1234";

        return data;
    }

    @AfterMethod
    public void down(){
        driver.quit();
    }

    /**
     * Created by joe on 7/9/2018.
     */

    @Listeners(com.selenium.screens.utility.Listener_Test.class)
    public static class EnterDetailsInRegistrationScreen extends BaseClass {
        @Test
        public void RegistrationScreenTest() {
            RegistrationScreen.tapOnHereLinkInLoginScreen();
            RegistrationScreen.enterDetailsInEmailField();
            LinkedHashMap<String, Object> emailAndPassword = (LinkedHashMap<String, Object>) RegistrationScreen.tapOnSubmitButton();
            driver.navigate().to("http://demo.guru99.com/V1/");
            RegistrationScreen.EnterDetailsInLoginScreen(emailAndPassword.get("User ID :"), "User name");
            RegistrationScreen.EnterDetailsInLoginScreen(emailAndPassword.get("Password :"), "Password");
            RegistrationScreen.tapOnLoginButton();

        }
    }
}
