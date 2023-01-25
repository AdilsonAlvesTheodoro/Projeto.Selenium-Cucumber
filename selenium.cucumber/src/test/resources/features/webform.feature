#Author: your.email@your.domain.com


Feature: Enviar formulario
Como usuario
Quero preencher o formulario
Para validar o envio

  @tag1
  Scenario:  Validar mensagem Received! apos o enivo do formulario
    Given que esteja no formualario
    When  enviar formualario com dados validos
    Then  valido mensagem de recebido