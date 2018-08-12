package com.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by joe on 7/6/2018.
 */
public class BaseClass {

   public static  WebDriver driver;


   @BeforeClass
   public void test() throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","D:\\Chrome driver\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("http://www.phptravels.net/");   //http://demosite.center/wordpress/wp-login.php, http://demo.guru99.com/V4/
       Thread.sleep(5000);
   }

    @AfterClass
    public void quit() {

        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus());
          captureScreenshot(result.getName());
    }

    public static void captureScreenshot(String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("C:\\Users\\joe\\IdeaProjects\\SeleniumAutomation\\screenshot" + name + ".png"));
    }

    public static boolean sendTextByName(String name, String message){
        int counter = 0;
        while(counter < 3) {
            try {
                boolean  status  = driver.findElement(By.name(name)).isDisplayed();
                if(status) {
                    driver.findElement(By.name(name)).clear();
                    driver.findElement(By.name(name)).sendKeys(message);
                    return true;
                }
            }catch (Exception e) {
                System.out.println(counter + "times trying to find" + name);
                counter++;
            }
        }
        return false;
    }

    public static boolean isElementDisplayedByClassName(String className) {

        int counter = 0;
        WebElement element = null;
        while (counter < 3) {
            try {
                element = driver.findElement(By.className(className));
                if (element.isDisplayed())
                    return true;
            } catch (Exception e) {
                System.out.println(counter + "times trying to find" + className);
                counter++;
            }
        }
        return false;
    }

    public static boolean isErrorTextDisplayed(String id) {

        int counter = 0;
        String text = null;
        while(counter < 3) {

            try {
                text = driver.findElement(By.id(id)).getText();
                System.out.println(text);
                if(text != null)
                    return true;
            }catch(Exception e) {
                System.out.println(counter + "times to trying to find" + id);
            }
            counter++;
        }
        return false;
    }

    public static boolean findElementByNameAndClick(String elementName) {

        int counter  = 0;
        WebElement element = null;
        while(counter < 3) {

            try {

                element = driver.findElement(By.name(elementName));
                if(element.isDisplayed()){
                    element.click();
                    return  true;
                }
            }catch (Exception e) {
                System.out.println(counter + "trying to find element" + elementName);
            }
            counter++;
        }
     return false;
    }

    public static boolean findElementByLinkTextAndClick(String linkText) {
        int counter = 0;
        WebElement element = null;
        while(counter < 3) {

            try {

                element = driver.findElement(By.linkText(linkText));
                if(element.isDisplayed()){
                    element.click();
                    return true;
                }

            }catch (EnumConstantNotPresentException e) {
                System.out.println("element not found" + e);
            }
            counter++;
        }
        return  false;
    }

    public static void sleep(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
