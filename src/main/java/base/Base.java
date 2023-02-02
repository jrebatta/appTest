package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Base {

    public static AppiumDriver<MobileElement> driver;
    public MobileElement driver2;

    public Alert alert;

    public Base(AppiumDriver<MobileElement> driver){
        Base.driver = driver;
    }

    public Base(MobileElement driver2){
        this.driver2 = driver2;
    }

    public Base() {

    }

    public void openApp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","emulador");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11.0");
        cap.setCapability("appPackage","com.booking");
        cap.setCapability("appActivity","com.booking.startup.HomeActivity");
        cap.setCapability("avdArgs", "-no-window");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(cap);
        System.out.println("start");

    }

    public MobileElement findElement(By locator){
        return driver.findElement(locator);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void login(String user, String pass){
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void visit(String url){
        driver.get(url);
    }

    public void isDisplayed(By locator){
        driver.findElement(locator).isDisplayed();
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    public void choose(String number, By locator) {
        Select selectList = new Select(findElement(locator));
        selectList.selectByValue(number);
    }

    public void chooseByText(String text, By locator) {
        Select selectList = new Select(findElement(locator));
        selectList.selectByVisibleText(text);
    }

    public static String getValueFromDataTable(DataTable dataTable, String title) {
        List<Map<String, String>> list = dataTable.asMaps();
        return (String)((Map)list.get(0)).get(title);
    }

    public void implicitWait(int number) throws InterruptedException {
        Thread.sleep(number);
    }

    public void alertAcept() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public String alertgetText() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }
}
