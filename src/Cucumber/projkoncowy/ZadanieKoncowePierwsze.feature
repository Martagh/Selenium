Feature: Address adding
  Scenario: user can add and delete address

    Given an open PrestaShop page
    When log in
    Then add first address
    And check if address is correct
