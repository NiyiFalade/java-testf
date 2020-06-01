package ibm.steps;


import Ibm.ui.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ibm.question.SearchHeading;
import ibm.question.TheDefaultLanguage;
import ibm.tasks.BrowseTo;
import ibm.tasks.SearchFor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasItems;


public class wiki_Steps {


    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the Wikipedia homepage$")
    public void kevinIsOnTheWikipediaHomepage(String actor) {

        OnStage.theActorCalled(actor).attemptsTo(
                BrowseTo.wikiPage()
        );
    }

    @And("^validate that language \"([^\"]*)\" is \"([^\"]*)\"$")
    public void validateThatLanguageIs(String arg0, String desiredLanguage) {

        String defaultLanguage = theActorCalled("Kevin").asksFor(TheDefaultLanguage.language());
        if (defaultLanguage.equalsIgnoreCase(desiredLanguage)) {
            //do nothing
        } else {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    SelectFromOptions.byVisibleText(desiredLanguage).from(HomePage.SELECT_LANG)
            );
        }
    }

    @And("^search for \"([^\"]*)\"$")
    public void searchFor(String arg0) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchFor.search(arg0)
        );
    }

    @And("^Search result heading matches the \"([^\"]*)\"$")
    public void searchResultHeadingMatchesTheQuery(String text) {
        theActorInTheSpotlight().should(
                seeThat("heading", SearchHeading.heading(), equalToIgnoringCase(text))
        );
    }

    @And("^search result is also displayed in other languages$")
    public void searchResultIsAlsoDisplayedInOtherLanguages(List<String> table) {

        theActorInTheSpotlight().should(
                seeThat("List of languages", SearchHeading.Languages(), hasItems(table.get(0), table.get(1)))
        );
    }

    @When("^change the search result language to \"([^\"]*)\"$")
    public void changeTheSearchResultLanguageTo(String arg0) {

        switch (arg0) {
            case "Francais":
                theActorInTheSpotlight().attemptsTo(
                        Click.on(HomePage.FRANCE)
                );
            default:
                System.out.println("no match");
        }
    }

    @Then("^search result contains the link to the (.*) version$")
    public void searchResultContainsTheLinkToTheEnglishVersion(String arg0) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.SEARCH_HEADING, isVisible()).forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat("List of languages", SearchHeading.Languages(), hasItems(equalToIgnoringCase(arg0)))
        );

    }



}
