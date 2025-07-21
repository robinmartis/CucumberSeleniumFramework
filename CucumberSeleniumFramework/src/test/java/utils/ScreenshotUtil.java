package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtil {

    private ScreenshotUtil() {}

    /**
     * Takes a screenshot, saves it to disk, and returns the raw PNG bytes.
     */
    public static byte[] capture(WebDriver driver, String scenarioName, String stepLabel) {
        if (driver == null) {
            return new byte[0];
        }
        try {
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Save to disk (target/screenshots/<timestamp>_<sanitizedScenario>_<stepLabel>.png)
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            String safeScenario = sanitize(scenarioName);
            String safeStep = sanitize(stepLabel);
            File outDir = new File("target/screenshots");
            if (!outDir.exists()) {
                outDir.mkdirs();
            }
            File outFile = new File(outDir, ts + "_" + safeScenario + "_" + safeStep + ".png");
            Files.write(outFile.toPath(), png);

            System.out.println("📷 Saved step screenshot: " + outFile.getAbsolutePath());
            return png;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (Exception e) {
            // Defensive: if driver quit mid-step, swallow
            System.out.println("⚠️ Could not capture screenshot: " + e.getMessage());
            return new byte[0];
        }
    }

    private static String sanitize(String in) {
        if (in == null) return "null";
        return in.replaceAll("[^a-zA-Z0-9._-]", "_");
    }
}
