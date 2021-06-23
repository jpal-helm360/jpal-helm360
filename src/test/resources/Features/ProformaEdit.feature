@PerformaEdit
Feature: PerformaEdit
  Description: To Validate PerformaEdit feature

  @PerformaEdit @Test
  Scenario Outline: PerformaEdit
    Given PE: Open PerformaEdit Process
    When PE: Click On Add
    Then PE: Enter Cost Type "<CostType>"
    Then PE: Enter Matter Number as "<Matter>"
    Then PE: Enter Timekeeper Number as "<Timekeeper>"
    Then PE: Enter Quantity as "<Quantity>"
    Then PE: Enter Work Currency as "<Currency>"
    Then PE: Enter Work Rate as "<Rate>"
    Then PE: Enter Narrative as "Narrative"
    Then PE: Click on PostAll
    Then PE: Validate Home Page is Displayed

    @PerformaEdit
    Examples: To Test PerformaEdit
      | CostType | Matter    | Timekeeper | Quantity | Currency | Rate |
      | Travel   | 10164-001 |       6593 |        2 | USD      |   10 |
     
