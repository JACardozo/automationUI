Feature: Contact form
  Scenario: Validate each field before to send message
    Given I went to "Contact us" page
    When I type "jcardozo" on email field under Contact us page
    And I press click on Send button
    Then An Error message "Invalid email address." should be displayed
    When I type "jcardozo2302@gmail.com" on email field under Contact us page
    And I press click on Send button
    Then An Error message "The message cannot be blank." should be displayed
    When I type "test message" on message field under Contact us page
    And I press click on Send button
    Then An Error message "Please select a subject from the list provided." should be displayed
    When I select "Customer service" from select subject
    And I press click on Send button
    Then The "Your message has been successfully sent to our team." message should be displayed
