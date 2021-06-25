@ProformaGeneration
Feature: ProformaGeneration
  Description: To Validate Proforma Generation feature

  @ProformaGeneration @Regression
  Scenario Outline: ProformaGeneration
    Given PG: Open Proforma Generation Process
    When PG: Click On Add Proforma Generation 
    And PG: Enter Description
    Then PG: Clear Reset Dates Using Field
    Then PG: Uncheck Inclues Entries on Other Proforma
    Then PG: Select Yesterday date in Time Start
    Then PG: Select Yesterday date in Cost Start
    Then PG: Select Yesterday date in Charge Start
    Then PG: Click Three Dot
    Then PG: Navigate to Proforma Generaton Child Form
    Then PG: Enter Matter
    Then PG: Generate Proforma
    Then PG: Verify Home Page Text

    Examples: To Test Proforma Generation
      | Matter    | Description |
      | 10158-001 | Test UI     |
