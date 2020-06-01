package ibm.steps;

import static Ibm.utilities.TestData.DataKeys.API_URL;
import static Ibm.utilities.TestData.DataKeys.BASE_URL;


import Ibm.MissingDataException;
import Ibm.utilities.TestData;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import cucumber.api.java.Before;

public class Hooks {
    @Steps
    private TestData testData;

    private EnvironmentVariables environmentVariables;


    @Before
    public void setTheStage(){

        testData.setData(BASE_URL, environmentVariables.optionalProperty("webdriver.base.url")
                .orElseThrow(() -> new MissingDataException("Missing environment property called webdriver.base.url")));

        testData.setData(API_URL, environmentVariables.optionalProperty("restapi.baseurl")
                .orElseThrow(() -> new MissingDataException("Missing environment property called restapi.baseurl")));
    }


}
