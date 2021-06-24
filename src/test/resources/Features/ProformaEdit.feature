@ProformaEdit
Feature: PerformaEdit
  Description: To Validate PerformaEdit feature

  @ProformaAdjustment
  Scenario Outline: ProformaAdjustment
    Given PE: Open PerformaEdit Process
    When PE: Search and Select Proforma for "<Proforma>"
    And PE: Extract Proforma Total Amount
    Then PE: Click On Three Dot
    Then PE: Open Apply Adjustment Child Form
    Then PE: Click On Grid-View
    Then PE: Click On Form-View
    Then PE: Enter Adjustment Amount in Percentage as "<AdjustmentAmount>"
    Then PE: Click On Adjustment Type
    Then PE: Select Adjustment Type as "<AdjustmentType>"
    Then PE: Navigate To Performa Recalc button
    Then PE: Performa Recalc
    Then PE: Compare Proforma Total Amount and Invoice Total Amount Before BillNoPrint
    Then PE: Performa BillNoPrint and Wait Few Second
    And PE: Get Invoice Number From Database
    Then PE: Open Invoice Process
    Then PE: Search and select Invoice Generated "<Invoice>"
    And PE: Extract Invoice Total Amount
    Then PE: Compare Proforma Total Amount and Invoice Total Amount After BillNoPrint
    Then PE: Click on Cancel

    Examples: To Test ProformaAdjustment
      | Proforma | AdjustmentAmount | AdjustmentType              | Invoice |
      |     1036 |                3 | Adjustment- Display on Bill |  100567 |
