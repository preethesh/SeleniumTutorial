package com.selenium.test.demos;

import com.selenium.BaseClass;
import com.selenium.screens.RegistrationScreen;
import com.selenium.screens.SeleniumScreen;
import org.testng.annotations.Test;


/**
 * Created by joe on 7/18/2018.
 */
public class SelectOptionInDropDownList extends BaseClass {

    @Test
    public void selectAnOption() throws InterruptedException {
       //RegistrationScreen.enterDetailsInEmailField();
        //RegistrationScreen.tapOnSubmitButton();
        Thread.sleep(500);
        SeleniumScreen.getListOfOptions();
        //SeleniumScreen.getListOfNavigationOptions();
    }


}
