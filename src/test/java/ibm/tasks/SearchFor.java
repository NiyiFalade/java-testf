package ibm.tasks;

import Ibm.ui.HomePage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;

public class SearchFor implements Task {

    private String key1;

    public SearchFor(String key1){
        this.key1 = key1;
    }

    public static Performable search(String key1){
        return Instrumented.instanceOf((SearchFor.class)).withProperties(key1);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(key1).into(HomePage.SEARCH),
                Click.on(HomePage.SUBMIT)
        );

    }
}
