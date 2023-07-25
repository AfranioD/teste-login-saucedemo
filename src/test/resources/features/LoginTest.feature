#Author: afraniodimasdasilva@gamil.com
@tag
Feature: Teste de Login no site SauceDemo

Scenario: Login com credenciais válidas
    Given que estou na página de login
    When eu preencho o campo de usuário com "standard_user"
    And eu preencho o campo de senha com "secret_sauce"
    And eu clico no botão de login
    Then eu sou redirecionado para a página de produtos

Scenario: Login com dados inválidos
    Given que estou na página de login
    When eu preencho o campo de usuário com "usuario_invalido"
    And eu preencho o campo de senha com "senha_invalida"
    And eu clico no botão de login
    Then uma mensagem de erro é exibida

Scenario: Login com campos em branco
    Given que estou na página de login
    When eu preencho o campo de usuário com ""
    And eu preencho o campo de senha com ""
    And eu clico no botão de login
    Then eu permaneço na página de login

