@ProformaGeneration
Feature: ProformaGeneration
  Description: To Validate ProformaGeneration feature

  @ProformaGeneration
  Scenario Outline: ProformaGeneration
    Given Open ProformaGeneration Process
    When Click On Add
    Then Verify Time Entry Form
    Then Enter Matter Number
    Then Select Time Type
    Then Enter Hours
    Then Enter Narrative
    Then Click on PostAll
    Then Validate Home Page is Displayed

    @ProformaGeneration
    Examples: To Test CostCard
      | Matter    |
      | 10177-001 |
