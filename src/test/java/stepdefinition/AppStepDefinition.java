package stepdefinition;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import paths.Paths;

import java.net.MalformedURLException;

public class AppStepDefinition extends Base {

    Paths pa = new Paths();


    @Given("Ingresar a la app")
    public void ingresarALaApp() throws MalformedURLException {
        openApp();


    }


    @And("Ingresar a la opcion de busqueda")
    public void ingresarALaOpcionDeBusqueda(){
        click(pa.btnCerrar);
    }

    @And("Ingresar los datos del alojamiento")
    public void ingresarLosDatosDelAlojamiento() throws InterruptedException {
         click(pa.textDestino);
         type("Cuzco",pa.textFinalDestino);
         implicitWait(1000);
         click(pa.opc1Cuzco);


    }
}
