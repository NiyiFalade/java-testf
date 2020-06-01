package ibm.question;

import Ibm.ui.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.CSSValue;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class SearchHeading {

    public static Question<String> heading() {
        return  actor -> Text.of(HomePage.SEARCH_HEADING).viewedBy(actor).asString();
    }

    public static Question<List<String>> Languages() {
        return  actor -> Text.of(HomePage.LANGUAGES).viewedBy(actor).asList();
    }
}
