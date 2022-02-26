Feature: As a user I want to verify that I can view images of a product

  Background:
    Given I am on the opencart homepage

  Scenario Outline: As a user I want to verify MacBook images display correctly
    Given I search for a <product> product
    And I click on the first search result
    When I click on the product image
    Then The product image is enlarged on screen
    And I can scroll through <numImages> images

  Examples:
  | product   | numImages |
  | MacBook   | 5         |
  | htc touch | 3         |
