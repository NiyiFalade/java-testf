package ibm.steps;

import Ibm.response.GetPetStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ibm.tasks.Api.Get;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import java.util.Arrays;
import java.util.List;

import static Ibm.urls.Urls.getPetStatus;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


public class GetPetByStatus_Steps {

    private WireMockServer wm;

    @Steps
    Get get;


    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) makes a request to know no pets with \"([^\"]*)\"$")
    public void harryMakesARequestToKnowNoPetsWithAnd(String actor, String status) {
        get.getPetsByStatus(status, getPetStatus.path(), actor);

    }

    @Then("^number of the pets \"([^\"]*)\" with \"([^\"]*)\" is \"([^\"]*)\"$")
    public void numberOfThePetsWithIs(String arg0, String arg1, Long arg2) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        List<GetPetStatus> getPetStatus = Arrays.asList(mapper.readValue(SerenityRest.lastResponse().getBody().asString(), GetPetStatus[].class));

        long occurances = getPetStatus.stream().filter(s -> s.getName().equalsIgnoreCase(arg0))
                .filter(t -> t.getStatus().equalsIgnoreCase(arg1))
                .count();
        int number = (int) occurances;
        assertThat(occurances).isEqualTo(arg2).withFailMessage("No of occurances is : " +  number);

    }


    public void setupStub() {

        wm = new WireMockServer(options().port(8089));

        wm.start();

        wm.stubFor(get(urlPathEqualTo("/v2/pet/findByStatus")
        ).withQueryParam("status", equalTo("available")).willReturn(aResponse().withHeader("Content-Type", "application/json")
                .withStatus(200).withBody("[\n" +
                        "    {\n" +
                        "        \"id\": 991,\n" +
                        "        \"category\": {\n" +
                        "            \"id\": 87,\n" +
                        "            \"name\": \"category991\"\n" +
                        "        },\n" +
                        "        \"name\": \"Doggie\",\n" +
                        "        \"photoUrls\": [\n" +
                        "            \"string\"\n" +
                        "        ],\n" +
                        "        \"tags\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"string\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"status\": \"available\"\n" +
                        "    }\n" +
                        "]")));


    }

    @Then("^number of the pets \"([^\"]*)\" with \"([^\"]*)\" is \"([^\"]*)\" using the mock service$")
    public void numberOfThePetsWithIsUsingTheMockService(String arg0, String arg1, Long arg2) throws JsonProcessingException {

        try {
            numberOfThePetsWithIs(arg0, arg1, arg2);
            verify(getRequestedFor(urlEqualTo("/v2/pet/findByStatus")));

        } catch(Exception e) {

        }finally {
            wm.stop();
        }
    }

    @Given("^mock service is running$")
    public void mockServiceIsRunning() {
        setupStub();
    }
}
