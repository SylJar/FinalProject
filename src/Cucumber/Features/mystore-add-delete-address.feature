Feature: add new user address then delete this address

  Scenario Outline: user adds new address for existing account and delete this address

    Given user with mystore account with opened website
    When user logs in with "<email>" and "<password>"
    And user goes to Addresses page
    And user clicks on + Create new address button
    When user fills "<alias>" as alias, "<address>" as address, "<city>" as city, "<postalCode>" as postal Code, country and "<phone>" as phone
    Then data in the added address is correct on Your Addresses page
    When user delete the above address by clicking on delete button
    Then address has been removed

    Examples:
      |password |email                      |alias   |address  |city  |postalCode|phone      |
      |zxcvbnm  |automation.tester@gmail.com|autotest|Oxford 10|London|66-666    |567-890-123|


