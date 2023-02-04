package runner;


import base.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/app.feature"},
        tags = "@TEST1",
        glue = {"stepdefinition"}
)
public class Runner {

//    @BeforeMethod
//    public static  void setupClass() throws MalformedURLException {
//        Base.openApp();
//    }
//
//    @AfterMethod
//    public static void teardownClass()  {
//        Base.closeApp();
//    }


}
