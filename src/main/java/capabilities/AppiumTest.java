package capabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {


    public static void main(String[] args) throws MalformedURLException {

         String fec = "04 febrero 2023";

         String fec2 = "//android.view.View[@content-desc=\""+fec+"\"]";

         By fechaIngreso = By.xpath("//android.view.View[@content-desc=\"04 febrero 2023\"]");
        System.out.println(fechaIngreso);
        System.out.println(fec2);

    }




}
