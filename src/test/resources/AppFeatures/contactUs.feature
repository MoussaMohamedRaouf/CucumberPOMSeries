Feature: Contact Us feature
  Scenario Outline: Contact Us scenario with different set of data
    Given user navigate to contact us page
    When user fills the form from the give sheet "<SheetName>" and row "<RowNumber>"
    And user clicks ob send button
    Then it shows success message "Your message has been successfully sent to our team."
    Examples:
      | SheetName | RowNumber |
      | contactus | 0         |
      | contactus | 1         |