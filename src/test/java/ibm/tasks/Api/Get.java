package ibm.tasks.Api;

import Ibm.utilities.TestData;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;

import static Ibm.utilities.TestData.DataKeys.API_URL;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class Get {

    @Steps
    private TestData testData;

    public void getPetsByStatus(String status,String path,String actor){
        OnStage.theActorCalled(actor)
                .whoCan(CallAnApi.at(testData.getData(API_URL)))
                .attemptsTo(
                        net.serenitybdd.screenplay.rest.interactions.Get.resource(path)
                            .with(request -> request.queryParam("status",status).log().all().header("Content-Type", "application/json"))
                );
        OnStage.theActorCalled(actor).should(
                seeThatResponse("",
                        response -> response.statusCode(200))
        );
    }
}
