Feature: search items

  Scenario Outline: The user should be able to find products by keyword on title name
    When I type "<Item>" on search field
    Then Only all items with "<Item>" word on the product title should be displayed
    Examples:
      | Item   |
      | Blouse |
      | Dress  |
