package com.selenium.test.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by joe on 8/3/2018.
 */
public class windowHandle {

    public static WebDriver driver;

    @Test
    public void getWindowHandles() {

        System.setProperty("webdriver.chrome.driver","D:\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://linkedin.com/");
        driver.manage().window().maximize();
        String mainHandle = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cust-svc-link")));
        driver.findElement(By.linkText("Help Center")).click();

        waitForNewWindowAndNavigate(driver);

        String searchText="Frequently Asked Questions";
        WebElement searchInputBox=driver.findElement(By.id("kw"));
        searchInputBox.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.cssSelector(".button.leftnoround.blue"));
        searchButton.click();

        WebElement resultedElement = driver.findElement(By.cssSelector(".rn_Element2"));
        String resultedText = resultedElement.getText().trim();
        System.out.println(resultedText);
        Assert.assertTrue(resultedText.contains(searchText), "Search successfull");

        closeAllOtherWindow(driver,mainHandle);
    }

    public static boolean closeAllOtherWindow(WebDriver driver, String handle) {

        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String window: allWindowHandles) {

            if(!window.equals(handle)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }

        driver.switchTo().window(handle);
        if(driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }

    public static void waitForNewWindowAndNavigate(WebDriver driver) {

        String cHandle = driver.getWindowHandle();
        String newWindowHandle = null;

        Set<String> allWindowHandles = driver.getWindowHandles();

        if(allWindowHandles.size() > 1) {

            for(String handles: allWindowHandles) {

                if(!cHandle.equals(handles)) {
                    newWindowHandle = handles;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            }

            if(cHandle.equals(newWindowHandle)) {
                throw new RuntimeException("testing");
            }
        }



    }
}
