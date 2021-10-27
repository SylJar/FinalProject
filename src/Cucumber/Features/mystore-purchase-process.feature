Feature: perform the full purchase process

  Scenario Outline: user places an order for the product: Hummingbird Printed Sweater

    Given user with MyStore account with opened website
    When user logs in with "<email>" and "<password>" to store
    And user adds address and fills "<alias>" as alias, "<address>" as address, "<city>" as city, "<postalCode>" as postal Code, country and "<phone>" as phone

    When user choose a clothes category
    And user choose the Hummingbird Printed Sweater for purchase
    Then check if the discount on it is correct

    When user selects the "<size>"
    And selects "<quantity>" pieces of product
    And add the product to the cart
    And go to the option - checkout
    Then user has "<quantity>" products in the cart

    When confirm the address
    And choose shipping method - PrestaShop pick up in store
    And selects the payment option - Pay by Check
    And accept the conditions and click on the order with an obligation to pay
    Then take a screenshot with the order confirmation
    And user goes to Order history and details page
    And user checks if the order is on the list with Awaiting check payment status and the same amount
    Then delete user address

    Examples:
      |password |email                      |alias   |address  |city  |postalCode|phone      |size|quantity|
      |zxcvbnm  |automation.tester@gmail.com|autotest|Oxford 10|London|66-666    |567-890-123|M   |5       |