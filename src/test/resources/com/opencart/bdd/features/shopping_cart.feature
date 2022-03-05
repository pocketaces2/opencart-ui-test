Feature: As a user I want to verify that the shopping cart page has listed my chosen items correctly

  Background:
    Given I am on the opencart homepage

  Scenario: As a user I want to verify product items and correctly listed on the shopping cart page
    Given I add the following products to the shopping cart
      | iPhone |
      | iMac   |
    When I go to the the shopping cart page
    Then the products are listed correctly