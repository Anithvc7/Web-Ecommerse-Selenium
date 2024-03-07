
@tag
Feature: Error Validation
  I want to use this template for my feature file



  

  @Regression
  Scenario Outline: Possitive Test of Submitting the order 
    Given I landed on Ecommerse Page
    When Login with username <name> and password <password>
    Then "Incorrect email or password" message is displayed

    Examples: 
      |name              | password   | 
      |anithvc@gmail.com | I143you@1  |
