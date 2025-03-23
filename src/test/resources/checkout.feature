Feature: Checkout Functionality

  Scenario: Successful Checkout
    Given Launch App
    When User selects product namely "Sauce Lab Back Packs" with "Blue color"
    Then User can see product detail page with "Sauce Lab Back Packs" selected
    When User adds 2 items
    Then User can see 2 products namely "Sauce Lab Back Packs" and total price at "$ 59.98" at cart page
    When User adds buyer details
    Then User can see payment details
    When User places order
    Then Success checkout page is displayed