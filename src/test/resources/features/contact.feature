Feature: Healthcourse contact module verification

  Background: common steps
    Given user is on the home page
    When user clicks on the contact module

  @HappyPath
  Scenario: click on contact module

    And  user enters name "qainterview"
    And user enters company "realcme"
    And user enters email "winie@tryninja.io"
    And user should be able to write message "This is an assignment for the QA position. Please ignore."
    And user enters phone number "999 999 9999"
    And user clicks submit button
    Then user sees the verify message "Thank you for contacting HealthCourse. Your message has been received."


  @UnhappyPath
  Scenario Outline: click on contact module

    And  user enters name "<name>"
    And user enters company "<company>"
    And user enters email "<email>"
    And user should be able to write message "<message>"
    And user enters phone number "<phone number>"
    And user clicks submit button
    Then user sees the verify message "<verify message>"
    Examples:
      | name        | company | email             | phone number | message                                                   | verify message                        |
      | qainterview |         |                   |              |                                                           | Please, fill in the following fields: |
      | qainterview | realcme |                   |              |                                                           | Please, fill in the following fields: |
      | qainterview | realcme | winie@tryninja.io |              |                                                           | Please, fill in the following fields: |
      | qainterview | realcme | winie@tryninja.io |              | This is an assignment for the QA position. Please ignore. | Please, fill in the following fields: |
      | qainterview | realcme | winie@tryninja.io | 999 999 9999 |                                                           | Please, fill in the following fields: |
      | qainterview | realcme | winietryninja.io  | 999 999 9999 | This is an assignment for the QA position. Please ignore. | Invalid email                         |
      | qainterview | realcme | winie@tryninja.io | 999 asd 99ga | This is an assignment for the QA position. Please ignore. | Only numbers allowed.                 |
