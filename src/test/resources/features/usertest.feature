Feature: User feature

  As a user, I want to check Admin module functionality(i.e. add user,delete user, find user records)

  @author_JigarPatel @sanity @smoke @regression
  Scenario: Admin Should Add User Successfully()
    Given I am on HomePage
    When Login to Application
    And click On Admin Tab
    Then Verify "System Users" text
    When click On Add button
    And verify addUser "Add User" Text
    When Select User Role "Admin"
    And enter Employee Name "Ranga Akunuri"
    And enter username "Jigar"
    And Select status "Disabled"
    And enter password "Test@123"
    And enter Confirm Password "Test@123"
    And click On Save Button
    Then verify message "Successfully Saved"

  @author_JigarPatel  @smoke @regression
  Scenario: Search The User Created And Verify It
    Given I am on HomePage
    When Login to Application
    And click On Admin Tab
    Then Verify "System Users" text
    When Enter Username "Jigar" into System User section
    And Select User Role "Admin" into System User section
    And Select Status "Disabled" into System User section
    And Click on Search Button from System Users Page
    Then Verify the User should be in Result list


  @author_JigarPatel @regression
  Scenario: verify That Admin Should Delete The User SuccessFully
    Given I am on HomePage
    When Login to Application
    And click On Admin Tab
    Then Verify "System Users" text
    And Enter Username "Jigar" into System User section
    And Select User Role "Admin" into System User section
    And Select Status "Disabled" into System User section
    And Click on Search Button from System Users Page
    Then Verify the User should be in Result list
    When Click on Check box
    And Click on Delete Button
    And Click on Ok Button on Popup
    And verify user deleted message "Successfully Deleted"

  @author_JigarPatel @regression
  Scenario Outline: Search The User And Verify The Message Record Found
    Given I am on HomePage
    When Login to Application
    And click On Admin Tab
    And Verify "System Users" text
    And  Enter username "<username>" from System User section
    And Select User role "<userRole>" from System User page
    And Enter EmployeeName "<employeeName>" from System User section
    And Select status "<status>" from System User section
    And Click on Search Button from System Users Page
    Then verify record found message "(1) Record Found"
    Then Verify username "<username>"
    And Click on Reset Tab
    Examples:
      | username | userRole | employeeName        | status |
      | Admin    | Admin    | manda akhil user    | Enabled |
      | FMLName  | ESS      | Qwerty Qwerty LName | Enabled |


