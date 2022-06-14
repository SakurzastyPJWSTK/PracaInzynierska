Feature: Github Login

  Scenario Outline: As a user, I can log into my profile

    Given I am on the login page
    When I login with correct login: <username> and password: <password>
    Then I should be successfully logged in

    Examples:
      | username             | password
      | test@test.com        | Password1!
      | test1@test.com       | Password2!

