@CostEntry
Feature: CostEntry
  Description: To Validate CostEntry feature

  @CostEntry 
  Scenario Outline: CostEntry
    Given CE: Open Process as "<Process>"
    When CE: Click On Add
    Then CE: Enter Cost Type "<CostType>"
    Then CE: Enter Matter Number as "<Matter>"
    Then CE: Enter Timekeeper Number as "<Timekeeper>"
    Then CE: Enter Quantity as "<Quantity>"
    Then CE: Enter Work Currency as "<Currency>"
    Then CE: Enter Narrative as "Narrative"
    Then CE: Click on PostAll
    Then CE: Validate Home Page is Displayed

    @CostEntry
    Examples: To Test CostEntry
      | Process    | CostType | Matter    | Timekeeper | Quantity | Currency | Rate |
      | Cost Entry | Travel   | 10164-001 |       6593 |        2 | USD      |   10 |
     # | Cost Entry | 004H     | 10280-001 |       4086 |        1 | USD      |   10 |
