@TimeEntry
Feature: TimeEntry
  Description: To Validate TimeEntry feature

  @TimeEntry @Sanity
  Scenario Outline: TimeEntry
    Given Open Time Entry Process
    When Click On Add
    Then Enter Timekeeper Number as "<TimeKeeper>"
    Then Enter Matter Number as "<Matter>"
    Then Select Time Type as "<TimeType>"
    Then Enter Hours as "<Hours>"
    Then Enter Narrative as "<Narrative>"
    Then Click on PostAll
    Then Validate Home Page is Displayed

  @TimeEntry @Regression
  Scenario Outline: TimeEntry
    Given Open Time Entry Process
    When Click On Add
    Then Enter Timekeeper Number as "<TimeKeeper>"
    Then Enter Matter Number as "<Matter>"
    Then Select Time Type as "<TimeType>"
    Then Enter Narrative as "<Narrative>"
    Then Click on PostAll

    @TimeEntry
    Examples: To Test TimeCard
      | TimeKeeper | Matter    | TimeType | Hours | Narrative    |
      |       4086 | 10280-001 | Hourly   |  0.15 | Perf-Ui-Test |
