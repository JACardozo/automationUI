Feature: add items to cart
  Scenario: Verify that items were stored for best sellers
    When I select the "best sellers"
    Then The "Printed Chiffon Dress" should be has "20"% of discount
    When I add "Printed Chiffon Dress" to the cart
    And I select "Continue shopping"
    And I add "Blouse" to the cart
    And I select "Continue shopping"
    And I select "Checkout" from "Cart" dropdown
    Then The selected items should be displayed in the summary table with availability display "In Stock"
    |Printed Chiffon Dress|
    |Blouse|
    When I remove the "Blouse" from the cart
    Then The "Blouse" item should not be longer displayed in the summary table
    And The total amount to pay should be $"18.40"

