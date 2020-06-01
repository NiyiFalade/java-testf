Test Framework is based on the Serenity Screenplay Pattern with Serenity BDD approach

Ensure Chromedriver is setup in the running machines path variable

Running the api test against the mock server 

mvn clean verify -Pmock -Dcucumber.options="--tags @mock"

Run the all test against the Live Service (Tests Runs in parallel)

mvn clean verify -Plive -Dcucumber.options="--tags @test"

Test Report

Once all the tests are completed .. Execute this command to aggregate the results

mvn serenity:aggregate

then the report can be found at: /target/site/serenity/index.html`


