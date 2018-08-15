Feature:Check the operation of main links

  Background:
    Given The user on AutoRia page

  Scenario Outline:The user navigates by Ria.com link to a new page
    Given The user click on Ria.com link
    When The user switch to new window
    Then The page https://www.ria.com/ was successfully loaded "<title>" "<url>"
    Examples:
    |title                                                    |url                 |
    |RIA.com ™ — доска бесплатных частных объявлений Украины.|https://www.ria.com/|

  Scenario Outline:The user navigates by https://dom.ria.com/ link to a new page
    Given The user click on Dom.ria.com link
    When The user switch to new window
    Then The page https://dom.ria.com/ was successfully loaded "<title>" "<url>"
  Examples:
  |title                                                                     |url                 |
  |DOM.RIA™ — вся недвижимость Украины. Продажа и аренда любой недвижимости.|https://dom.ria.com/?utm_source=auto_ria&utm_medium=text_link&utm_content=nedvigimost&utm_campaign=header|

  Scenario Outline:The user navigates by https://market.ria.com/ link to a new page
    Given The user click on Автотовары link
    When The user switch to new window
    Then The page https://market.ria.com/ was successfully loaded "<title>" "<url>"
    Examples:
      |title                                                            |url                 |
      |MARKET.RIA — шины, диски и аксессуары для авто по выгодным ценам|https://market.ria.com/?utm_source=auto.ria.com&utm_medium=text_link&utm_content=magazin_avtotovarov&utm_campaign=header|


  Scenario Outline:The user navigates by Ria.com link to a new page
    Given The user click on Автозапчасти link
    When The user switch to new window
    Then The page https://zapchasti.ria.com/ was successfully loaded "<title>" "<url>"
    Examples:
      |title                                                    |url                       |
      |1 000 000+ запчастей на авто в Украине на ZAPCHASTI.RIA  |https://zapchasti.ria.com/|