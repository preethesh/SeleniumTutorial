package com.selenium.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.selenium.BaseClass.*;

//import static com.selenium.BaseClass.driver;

/**
 * Created by joe on 7/18/2018.
 */
public class SeleniumScreen {

    public static void getListOfOptions() {

       // Select dropdown = new Select(driver.findElement(By.className("dropdown-menu")));
        driver.findElement(By.className("dropdown-toggle")).click();
        WebElement dropdown = driver.findElement(By.cssSelector(".dropdown-menu"));
        List<WebElement> list = dropdown.findElements(By.tagName("li"));
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            WebElement name = list.get(i);
            System.out.println(name.getText());
        }

    }

    public static void getListOfNavigationOptions() {
        WebElement element = driver.findElement(By.cssSelector("div#navbar-brand-centered"));
        List<WebElement> nav_list = element.findElements(By.tagName("li"));
        System.out.println(nav_list.size());
        for(int i=0; i<nav_list.size(); i++) {
            WebElement name = nav_list.get(i);
            System.out.println("name" + name);
            System.out.println();
        }
    }
}
