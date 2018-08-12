package com.selenium.test.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.selenium.BaseClass.driver;
import static com.selenium.BaseClass.sleep;

/**
 * Created by joe on 8/3/2018.
 */
public class FramesInSelenium {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver","D:\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        //driver.switchTo().frame("a077aa5e");
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        for(int i=0; i<size; i++) {
            driver.switchTo().frame(i);
            int total = driver.findElements(By.xpath("html/body/a/img")).size();
            System.out.println(total);
            sleep(5000);
            driver.switchTo().defaultContent();

        }

           driver.close();
    }
}
