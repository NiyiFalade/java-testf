package ibm.question;

import Ibm.ui.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheDefaultLanguage {
    public static Question<String> language() {
        return  actor -> Text.of(HomePage.DEFAULT_LANGUAGE).viewedBy(actor).asString();
    }
}
