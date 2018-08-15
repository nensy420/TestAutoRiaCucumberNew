Feature: Verification of the search results
  Background:
    Given The user on AutoRia page
  Scenario Outline: The search results correspond to the specified parameters: brand and mark of the car
    When The user enters the car brand "<car brand>",mark of the car"<mark>" in the search form
    And The user clicks on search button
    Then The user sees that results of search match the specified search parameters  car brand"<car brand>" mark of the car"<mark>"
    Examples:
    |car brand|mark |
    |Audi     |100  |
    |BMW      |X5   |
    |Honda    |Civic|

  Scenario Outline: The search results correspond to the specified parameters: year of the car
    When The user enters the year from "<year from>",year to "<year to>" in the search form
    And The user clicks on search button
    Then The user sees that results of search match the specified search parameters year from"<year from>"  year to"<year to>"
    Examples:
      |year from|year to|
      |2002     |2009   |
      |2010     |2014   |
      |2015     |2018   |

  Scenario Outline: The search results correspond to the specified parameters: price of the car
    When The user enters the price from "<price from>",price to "<price to>" in the search form
    And The user clicks on search button
    Then The user sees that results of search match the specified search parameters price from "<price from>" price to"<price to>"
    Examples:
      |price from|price to|
      |0         |9999    |
      |10000     |49999   |
      |50000     |100000  |

  Scenario Outline: The search results correspond to the specified parameters: region
    When The user enters the region "<region>" in the search form
    And The user clicks on search button
    Then The user sees that results of search match the specified search parameters region "<list of cities in the region>"
    Examples:
    |region    |list of cities in the region|
    |Винница   |Винница, Жмеринка, Казатин, Крыжополь, Липовец, Литин, Могилев-Подольский, Мурованые Куриловцы, Немиров, Оратов, Песчанка, Погребище, Теплик, Тывров, Томашполь, Тростянец, Тульчин, Хмельник, Черновцы, Чечельник, Шаргород, Ямполь, Бар, Бершадь, Гайсин, Ильинцы, Калиновка, Гнивань, Ладыжин, Якушинцы                            |
    |Тернополь |Тернополь, Бережаны, Борщев, Бучач, Гусятин, Залещики, Збараж, Зборов, Козова, Кременец, Монастыриска, Подволочиск, Подгайцы, Теребовля, Чортков, Шумск, Лановцы                            |
    |Житомир   |Житомир, Андрушевка, Барановка, Бердичев, Брусилов, Хорошев (Володарск-Волынский), Емильчино, Коростень, Коростышев, Лугины, Любар, Малин, Народичи, Новоград-Волынский, Овруч, Олевск, Попельня, Радомышль, Ружин, Пулины (Червоноармейск), Черняхов, Чуднов, Романов                            |

