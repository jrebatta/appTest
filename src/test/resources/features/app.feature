#language: en

@TESTS
Feature: Flujo completo

  @TEST1
  Scenario: Flujo completo con servicio de alojamiento
    Given Ingresar a la app
    And Ingresar a la opcion de busqueda
    And Ingresar los datos del alojamiento
#    When I click on Show all pokemons
#    Then The pokemons are listed