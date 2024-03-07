
@tag
Feature: Purchase the order from Ecommerse Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerse Page

  

  @tag2
  Scenario Outline: Possitive Test of Submitting the order 
    Given Login with username <name> and password <password>
    When I add product <productneeded> to Cart
    And CheckOut<productneeded> and Submit the Order
    Then "THANKYOU FOR THE ORDER." message is displaying on Confirmation page 

    Examples: 
      |name              | password   | productneeded  |
      |anithvc@gmail.com | I143you@   |ADIDAS ORIGINAL |
      
