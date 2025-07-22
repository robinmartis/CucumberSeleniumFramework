package utils;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.PatternLayout;

import com.aventstack.extentreports.Status;

import java.io.Serializable;

@Plugin(name = "ExtentLogAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
public class ExtentLogAppender extends AbstractAppender {

    protected ExtentLogAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @PluginFactory
    public static ExtentLogAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout) {
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new ExtentLogAppender(name, filter, layout, true);
    }

    @Override
    public void append(LogEvent event) {
        if (ExtentReportManager.getTest() != null) {
            String message = new String(getLayout().toByteArray(event)).trim();
            System.out.println("ExtentLogAppender >> " + message);
            ExtentReportManager.getTest().log(Status.INFO, message);
        } else {
            System.out.println("ExtentLogAppender >> Test is NULL, skipping log.");
        }
    }
}
