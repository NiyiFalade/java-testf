package Ibm.utilities;



import lombok.NoArgsConstructor;
import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public class TestData {

    private static Logger logger = LoggerFactory.getLogger(TestData.class);

    public <T> void setData(DataKeys key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public <T> T getData(DataKeys key) {
        return Serenity.sessionVariableCalled(key);
    }


    public enum DataKeys {
        BASE_URL,
        API_URL
    }
}
