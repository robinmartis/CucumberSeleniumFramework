package utils;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepStarted;

public class StepTracker implements EventListener {

    public static String currentStep = "";

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, event -> {
            // Get step keyword + step text
            currentStep = event.getTestStep().toString();
        });
    }
}
