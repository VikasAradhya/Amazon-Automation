Feature: Purchase a Product From Amazon Website

  Background:
    Given I landed on Amazon WebPage

    Scenario Outline: Positive test To Submit The Order
      Given Search For Product<pName>
      When I Add Product<model> To Cart
      And Go to CartPage and Set Qty<Quantity>
      Then Login with email<email> and pass <password>
      Examples:
        | pName  | model                                   | Quantity | email                     | password   |
        | iphone | Apple iPhone 14 Pro Max (256 GB) - Gold | 2        | aradhyavikas123@gmail.com | Vicky@1996 |


