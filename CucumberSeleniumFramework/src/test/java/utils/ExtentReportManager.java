package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentSpark.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
