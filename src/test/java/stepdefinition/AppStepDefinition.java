package stepdefinition;

import base.Base;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import paths.Paths;
import utils.Excel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppStepDefinition extends Base {

    Paths pa = new Paths();

    Excel ex = new Excel();


    @Given("Ingresar a la app")
    public void ingresarALaApp() throws MalformedURLException {
        openApp();


    }


    @When("Ingresar a la opcion de busqueda")
    public void ingresarALaOpcionDeBusqueda() throws InterruptedException {
        click(pa.btnCerrar);
    }

    @And("Ingresar los datos del alojamiento")
    public void ingresarLosDatosDelAlojamiento() throws IOException {
        click(pa.textDestino);
        type(ex.getCellValue("Hoja1",1,0),pa.textFinalDestino);
        click(pa.opc1);
        String fec1 = ex.getCellValue("Hoja1",1,1);
        String fec2 = ex.getCellValue("Hoja1",1,2);
        elegirFecha(fec1);
        elegirFecha(fec2);
        click(pa.selectFecha);
    }

    @And("Ingresar la cantidad de cuartos y personas y buscar")
    public void ingresarLaCantidadDeCuartosYPersonasYYBuscar() throws IOException {
        click(pa.selectCuartosyPersonas);
        click(pa.menosNumAdultos);
        elegirCuartoyAdulto(ex.getCellValue("Hoja1",1,4),pa.numAdultos);
        elegirCuartoyAdulto(ex.getCellValue("Hoja1",1,3),pa.numCuartos);
        click(pa.numNino);
        click(pa.numNinoMenos1ano);
        click(pa.btnOk);
        click(pa.btnApply);
        click(pa.btnBuscar);
    }

    @And("Selecionar la opcion mas economica")
    public void selecionarLaOpcionMasEconomica() {
        click(pa.btnFiltro);
        click(pa.btnPrecioBajo);
        click(pa.opcEconomica);
    }

    @And("Validar que los datos esten correctos y continuar")
    public void validarQueLosDatosEstenCorrectosYContinuar() throws IOException, ParseException {
        String fec1 = ex.getCellValue("Hoja1",1,1);
        String fec2 = ex.getCellValue("Hoja1",1,2);
        Date fecfor1 = formatearFecha(fec1);
        Date fecfor2 = formatearFecha(fec2);
        int milisecondsByDay = 86400000;
        int dias = (int) ((fecfor2.getTime()-fecfor1.getTime()) / milisecondsByDay);
        String[] part = getText(pa.datosReserva).split(" ");
        int noches = Integer.parseInt(part[2]);
        String adultos = part[4];
        String niños = part[6];
        Assert.assertEquals(dias,noches);
        Assert.assertEquals(adultos,ex.getCellValue("Hoja1",1,4));
        Assert.assertEquals(niños,ex.getCellValue("Hoja1",1,5));
        click(pa.btnSeeAva);
    }

    @And("Selecionar la opcion privada y mas economica")
    public void selecionarLaOpcionPrivadaYMasEconomica() {
        click(pa.btnSelct);

    }

    @And("Selecionar las preferencias de fumar y confirmar")
    public void selecionarLasPreferenciasDeFumarYConfirmar() {
        click(pa.btnSmokingRoom);
        click(pa.btnConfirm);
        click(pa.btnReserve);
    }

    @And("Confirmar reserva con los datos")
    public void confirmarReservaConLosDatos() {

        type("Juan",pa.apellido); //ape
        type("Perez",pa.apellido); //email
        type("juan.perez@gmail.com",pa.apellido); //pais
        type("Peru",pa.pais); //numero
        type("+51991478545",pa.pais); //nombre
        System.out.println("");
        click(pa.btnAdd);



    }

    @And("Confirmar datos de la reserva y días")
    public void confirmarDatosDeLaReservaYDías() {

    }

    @Then("Ingresar datos de tarjeta y reservar")
    public void ingresarDatosDeTarjetaYReservar() {
    }
}
