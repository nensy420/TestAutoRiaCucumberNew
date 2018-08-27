Feature: Check invalid authorization

  Scenario: The user can't authorization with wrong mobile number
    Given The user on AutoRia page
    When The user click on Login link
    And The user click on Sign up link
    And The user enters the wrong telephone = "0326j79" number
    And The user clicks on submit button
    Then The user watches the error message on the screen