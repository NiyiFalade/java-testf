package Ibm.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target DEFAULT_LANGUAGE = Target.the("default language").located(By.xpath("//*[@id=\"jsLangLabel\"]"));
    public static final Target SEARCH = Target.the("searchInput").located(By.xpath(("//*[@id=\"searchInput\"]")));
    public static final Target SUBMIT = Target.the("submit").located(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i"));
    public static final Target SELECT_LANG = Target.the("Lang dropdown").located(By.xpath("//*[@id=\"searchLanguage\"]"));
    public static final Target SEARCH_HEADING = Target.the("searchHeading").located(By.xpath("//*[@id=\"firstHeading\"]"));
    public static final Target LANGUAGES = Target.the("languages").located(By.xpath("//*[@id=\"p-lang\"]/div/ul/li"));
    public static final Target FRANCE = Target.the("France").located(By.xpath("//*[@href='https://fr.wikipedia.org/wiki/Monnaie']"));
}
