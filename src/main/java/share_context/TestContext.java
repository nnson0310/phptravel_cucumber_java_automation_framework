package share_context;

import com.aventstack.extentreports.model.Test;

/**
 * This class mainly used for sharing context between step definitions
 * with the help of DI (pico-container dependency injection)
 * Create private variable and a getter method for its
 * @author Son
 */
public class TestContext {

    private ScenarioContext scenarioContext;

    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
