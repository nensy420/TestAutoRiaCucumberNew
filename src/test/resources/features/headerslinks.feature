Feature:Check the operation of main links

  Background:
    Given The user on AutoRia page

  Scenario:The user navigates by Ria.com link to a new page
    Given The user click on Ria.com link
    When The user switch to new window
    Then The page https://www.ria.com/ was successfully loaded

  Scenario:The user navigates by https://dom.ria.com/ link to a new page
    Given The user click on Dom.ria.com link
    When The user switch to new window
    Then The page https://dom.ria.com/ was successfully loaded

  Scenario:The user navigates by https://market.ria.com/ link to a new page
    Given The user click on Автотовары link
    When The user switch to new window
    Then The page https://market.ria.com/ was successfully loaded

  Scenario:The user navigates by https://zapchasti.ria.com/ link to a new page
    Given The user click on Автозапчасти link
    When The user switch to new window
    Then The page https://zapchasti.ria.com/ was successfully loaded
