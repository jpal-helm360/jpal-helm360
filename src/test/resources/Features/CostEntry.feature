Feature: CostEntry
  Description: To Validate CostEntry feature

  @CostEntry @Regression
  Scenario Outline: CostEntry
    Given CE: Open Process as "<Process>"
    When CE: Click On Add
    Then CE: Enter Cost Type "<CostType>"
    Then CE: Enter Matter Number as "<Matter>"
    Then CE: Enter Timekeeper Number as "<Timekeeper>"
    Then CE: Enter Quantity as "<Quantity>"
    Then CE: Enter Work Currency as "<Currency>"
    Then CE: Enter Work Rate as "<Rate>"
    Then CE: Enter Narrative as "Narrative"
    Then CE: Click on PostAll
    Then CE: Validate Home Page is Displayed

    Examples: To Test CostEntry
      | Process    | CostType | Matter    | Timekeeper | Quantity | Currency | Rate | Narrative    |
      | Cost Entry | Travel   | 10164-001 |       6593 |        1 | KZT      |   10 | Perf-Ui-Test |
