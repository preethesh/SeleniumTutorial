package com.selenium.test.phpTravels;

import com.selenium.BaseClass;
import com.selenium.screens.TravelsDashboardScreen;
import org.testng.annotations.Test;

/**
 * Created by joe on 8/6/2018.
 */
public class OptionListFromNavBar extends BaseClass {

    @Test
    public  void getTheOptionListFromMainPage() {
        TravelsDashboardScreen.optionList();
    }
}
