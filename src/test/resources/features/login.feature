Feature: Ingresar al aplicativo web

  como cliente de la aplicion web
  quiero ingresar en el aplicativo
  para comprar productos

  Scenario: Ingreso correcto del cliente
    Given que el cliente entre a la pagina web
    When ingrese los datos correctos para el logeo
    Then podra ingresar a la cuenta


  Scenario: Ingreso incorrecto del cliente
    Given que el cliente entre a la pagina web
    When ingrese los datos que no pertenezcan a ninguna cuenta registrada
    Then no podra ingresar


