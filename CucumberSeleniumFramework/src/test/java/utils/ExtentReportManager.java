package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    

//    public static ExtentReports getReporter() {
//        if (extent == null) {
//            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentSpark.html");
//            spark.config().setTheme(Theme.STANDARD);
//            spark.config().setDocumentTitle("Automation Report");
//            spark.config().setReportName("Test Results");
//
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//        }
//        return extent;
//    }
    
 // Initialize ExtentReports instance
    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentReport.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Test Execution Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
    
    // Set current test instance
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    // Get current test instance
    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush all reports
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
    
}
