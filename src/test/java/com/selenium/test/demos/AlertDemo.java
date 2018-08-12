package com.selenium.test.demos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.selenium.BaseClass.sleep;
import static com.selenium.test.demos.windowHandle.driver;

/**
 * Created by joe on 8/3/2018.
 */
public class AlertDemo {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver","D:\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage= driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        sleep(5000);

        // Accepting alert
        alert.dismiss();

        driver.quit();
    }
}

