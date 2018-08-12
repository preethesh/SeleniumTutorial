package com.selenium.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.selenium.BaseClass.driver;
import static com.selenium.BaseClass.sleep;

/**
 * Created by joe on 8/6/2018.
 */
public class TravelsDashboardScreen {

    public static void optionList() {

        WebElement navBarElement = driver.findElement(By.id("collapse")).findElement(By.className("navbar-nav"));
        List<WebElement> elementList = navBarElement.findElements(By.tagName("li"));
        System.out.println(elementList.size());
        for (int i = 0; i < elementList.size(); i++) {
            WebElement element = elementList.get(i);
            System.out.println(element.getText());
        }

        WebElement table = driver.findElement(By.id("HOTELS"));
        List<WebElement> list = table.findElements(By.className("row"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            WebElement name = list.get(i);
            String text1 = name.getText();
            System.out.println(text1);
        }

        WebElement element = driver.findElement(By.id("HOTELS"));
        List<WebElement> list1 = element.findElements(By.className("bgfade"));
        System.out.println("list1" + " " + list1.size());
        for (int i = 0; i < list1.size(); i++) {
            WebElement row = list1.get(i);
            WebElement text1 = row.findElement(By.className("row")).findElement(By.className("form-control"));
            String value = text1.getAttribute("value").isEmpty() ? text1.getAttribute("placeholder") : text1.getAttribute("value");
            System.out.println(value);
        }

        WebElement buttonName = driver.findElement(By.cssSelector(".tab-content.shad")).findElement(By.className("search-button"));
        String buttonText = buttonName.getText();
        System.out.println(buttonText);
    }

}
