#language: en

@TESTS
Feature: Flujo completo

  @TEST1
  Scenario: Flujo completo con servicio de alojamiento
    Given Ingresar a la app
    When Ingresar a la opcion de busqueda
    And Ingresar los datos del alojamiento
    And Ingresar la cantidad de cuartos y personas y buscar
    And Selecionar la opcion mas economica
    And Validar que los datos esten correctos y continuar
    And Selecionar la opcion privada y mas economica
    And Selecionar las preferencias de fumar y confirmar
    And Confirmar reserva con los datos
    And Confirmar datos de la reserva y días
    Then Ingresar datos de tarjeta y reservar
