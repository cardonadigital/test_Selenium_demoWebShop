Feature: Registrar un nuevo usuario

  como cliente de la aplicion web
  quiero registrarme en el aplicativo
  para comprar productos

  Scenario: registro correcto del cliente
    Given que el cliente entro a la pagina de registro
    When llene el formulario correctamente.
    Then recibira el siguiente mensaje "Your registration completed".

  Scenario: registro correcto del cliente
    Given que el cliente entro a la pagina de registro
    When llene el formulario correctamente.
    Then recibira el siguiente mensaje "Your registration completed".