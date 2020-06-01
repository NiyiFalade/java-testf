package ibm.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.EnterValue;

public class ChangeLang implements Task {

    private String lang;

    public ChangeLang(String cLang){
        this.lang = cLang;
    }

    public static Performable changeLang(String txt){
        return Instrumented.instanceOf((ChangeLang.class)).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on()
        );

    }
}
