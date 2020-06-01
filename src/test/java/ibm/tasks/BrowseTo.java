package ibm.tasks;

import Ibm.ui.HomePage;
import Ibm.utilities.TestData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class BrowseTo implements Performable {

    private static String url = "";
    private static TestData testData = new TestData();

    public static Performable wikiPage() {
        url = testData.getData(TestData.DataKeys.BASE_URL);
        return Instrumented.instanceOf((BrowseTo.class)).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url),
                WaitUntil.the(HomePage.SEARCH, isVisible()).forNoMoreThan(10).seconds()
        );

    }
}
