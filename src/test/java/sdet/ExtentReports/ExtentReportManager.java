package sdet.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent ; // populate common info on report
    public ExtentTest test; // creating TC entries and updating status of test methods

    @Override
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester","Amit");
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("Browser","Chrome");
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"Test Case Passed "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL,"Test Case Failed "+result.getName());
        test.log(Status.FAIL,"Test Case Failed because"+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.SKIP,"Test Case Skipped "+result.getName());
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
