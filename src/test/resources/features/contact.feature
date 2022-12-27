Feature: Ingresar al modulo de contacto

  como cliente de la aplicion web
  quiero ingresar en el modulo de contactenos (Contact Us)
  para poder enviar un mensaje de opinion/queja/reclamo

  Scenario: Envio mensaje correctamente
    Given que el cliente entre al modulo de contactenos
    When ingrese los datos correctos en los campos solicitados
    Then podra enviar el mensaje exitosamente


  Scenario: Ingreso incorrecto del cliente
    Given que el cliente ingrese al modulo de contactenos
    When no ingrese el nombre
    Then el sistema debera mostrar el siguiente mensaje "Enter your name"