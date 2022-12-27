Feature: Registrar un nuevo usuario

  como cliente de la aplicion web
  quiero registrarme en el aplicativo
  para comprar productos

  Scenario: Registro correcto del cliente
    Given que el cliente entre a la pagina de registro
    When llene el formulario correctamente
    Then recibira el siguiente mensaje "Your registration completed"

  Scenario Outline: Campos incompletos registro cliente
    Given que el cliente ingrese a la pagina de registro
    When no llene el campo: "<campo>"
    Then recibira el siguiente mensaje: "<campo>" is required
    Examples:
      | campo            |
      | First name       |
      | Last name        |
      | Email            |
      | Password         |