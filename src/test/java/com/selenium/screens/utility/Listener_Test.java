package com.selenium.screens.utility;
import com.selenium.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * Created by joe on 8/2/2018.
 */
public class Listener_Test implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + "test Started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println(iTestResult.getName() + "test case success");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println(iTestResult.getName() + "test case failed");


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
