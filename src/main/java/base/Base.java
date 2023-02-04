package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Base {

    public String fechaFormateada;
    public Date fec;


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

    public static void openApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","sdk_gphone_x86");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11.0");
        cap.setCapability("appPackage","com.booking");
        cap.setCapability("appActivity","com.booking.startup.HomeActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(cap);
        System.out.println("start");

    }
    public static void closeApp() {

        driver.quit();

    }

    public MobileElement findElement(By locator){
        return driver.findElement(locator);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        implicitWait(2000);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }
    public void login(String user, String pass){
    }

    public void click(By locator){
        implicitWait(2000);
        driver.findElement(locator).click();
    }

    public void clickFast(By locator){
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

    public void implicitWait(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void alertAcept() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public String alertgetText() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void elegirFecha(String fecha){
        implicitWait(2000);
        String fec = "//android.view.View[@content-desc=\""+fecha+"\"]";
        click(By.xpath(fec));

    }

    public void scrollToElement(String locator)
    {
        try
        {
            JavascriptExecutor js = driver;
            js.executeScript("arguments[0].scrollIntoView();", locator);
        }
        catch (Exception e)
        {
            System.err.println("Unable to scroll to element. Element is not visible.");
        }
    }

    public void elegirCuartoyAdulto(String cantidad, By locator){
        int cant = Integer.parseInt(cantidad);
        if (cant == 1){
            System.out.println("solo 1");
        }else if (cant>1){
            for (int i = 1; i <= cant-1; i++) {
                clickFast(locator);
            }
        }

    }

    public Date formatearFecha(String fecha) throws ParseException {
        String[] part = fecha.split(" ");
        String dia = part[0];
        String mesString = part[1];
        String ano = part[2];
        int mesInt = (mesString.equals("January"))?1:(mesString.equals("February"))?2
                :(mesString.equals("March"))?3:(mesString.equals("April"))?4
                :(mesString.equals("May"))?5:(mesString.equals("June"))?6
                :(mesString.equals("July"))?7:(mesString.equals("August"))?8
                :(mesString.equals("September"))?9:(mesString.equals("October"))?10
                :(mesString.equals("November"))?11:(mesString.equals("December"))?12:0;

        String mes = String.valueOf(mesInt);
        if (mes.length()<2){
            mes = "0"+mes;
        }

        fechaFormateada  = dia+"/"+mes+"/"+ano;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        fec = formato.parse(fechaFormateada);
        System.out.println(fec);



        return fec;
    }

    public void obtnerDatos(){
        implicitWait(5000);
        String datos = driver.getPageSource();
    }




//    public void screenShot()
//    {
//        implicitWait(2000);
////        String NameCarpeta = MetodosVarios.getCarpeta();
////        String fileWithPath = metodos.rutaEvidencia()+NameCarpeta+"/"+metodos.nombreImagen();
//
//        takeSnapShot(driver, fileWithPath);
//
//    }

//    public void waitLoaderVisible(String varLocator) {
//        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
//        String clase = elements[2].getClassName();
//        String metodo = elements[2].getMethodName();
//
//
//        try {
//            AppiumDriv wait = new WebDriverWait(driver, 10);
//        }catch (Exception e)
//        {
//            assertTrue("Error en Locator "+varLocator,false);
//        }
//    }
}
