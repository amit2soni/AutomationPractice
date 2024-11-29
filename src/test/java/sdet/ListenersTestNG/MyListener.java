package sdet.ListenersTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution starts");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test starts");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Fails");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skips");
    }


    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Execution Finish");
    }
}
