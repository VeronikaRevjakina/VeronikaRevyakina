Feature: Exercise1Test

  Scenario: Different Elements Page test
    When I open test site by URL 'https://epam.github.io/JDI/'
    Then 'Home Page' page is opened
    When I login as user with
      | userName | password |
      | epam     | 1234     |
    Then User name should be 'PITER CHAILOVSKII'
    And 4 images are displayed on Home page
    And 4 texts under icons are displayed on Home page
    And 2 main headers are displayed on Home page
    When I click on 'Service' button in Header
    Then Dropdown header Service list should be displayed
    And Service header menu should have items
      | SUPPORT            |
      | DATES              |
      | SEARCH             |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |
    When I click 'Service' left side menu button
    Then Dropdown left side menu Service list should be displayed
    And Service left side menu should have items
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | Search             |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |
    Given I click header menu 'Service' button
    When I click on 'DIFFERENT ELEMENTS' button in Service dropdown
    Then 'Different Elements' page is opened
    And 4 checkboxes are displayed on Different Elements Page
    And 4 radios are displayed on Different Elements Page
    And 1 dropdown are displayed on Different Elements Page
    And 2 buttons are displayed on Different Elements Page
    And Right Section is displayed on Different Elements Page
    And Left Section is displayed on Different Elements Page
    When I click 'Water' checkbox
    And I click 'Wind' checkbox
    Then Checkbox 'Water' is selected
    And Checkbox 'Wind' is selected
    And Log row should be displayed with value 'Water' and condition 'true'
    And Log row should be displayed with value 'Wind' and condition 'true'
    When I click 'Selen' radio
    Then Radio 'Selen' is selected
    And Log row should be displayed with value 'metal' and condition 'Selen'
    When I click 'Yellow' option in Colors dropdown
    Then Dropdown 'Yellow' color is selected
    And Log row should be displayed with value 'Colors' and condition 'Yellow'
    When I click 'Water' checkbox
    And I click 'Wind' checkbox
    Then Checkbox 'Water' is unselected
    And Checkbox 'Wind' is unselected
    And Log row should be displayed with value 'Water' and condition 'false'
    And Log row should be displayed with value 'Wind' and condition 'false'