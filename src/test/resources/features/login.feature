Feature: Ingresar al aplicativo web

  como cliente de la aplicion web
  quiero ingresar en el aplicativo
  para comprar productos
  @reTest @regresion
  Scenario: Ingreso correcto del cliente
    Given que el cliente entre al modulo de logueo
    When ingrese los datos correctos para el logeo
    Then podra ingresar a la cuenta

  @reTest
  Scenario: Ingreso incorrecto del cliente
    Given que el cliente ingrese al modulo de logueo
    When ingrese los datos que no pertenezcan a ninguna cuenta registrada
    Then no podra ingresar a la cuenta


