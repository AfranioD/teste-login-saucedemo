package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "steps")
public class TestRunner {
    // Aqui não  precisa ser implementado nada, apenas a anotação da classe.
}

