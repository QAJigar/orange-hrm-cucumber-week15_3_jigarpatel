Feature: Login Feature
  As a user i am able to login

  @author_JigarPatel @smoke @sanity @regression
  Scenario: verify User Should Login SuccessFully
    Given  I am on HomePage
    When Enter username
    And Enter password
    And Click on Login Button
    Then Verify "Dashboard" Message should displayed

  @author_JigarPatel @smoke @regression
  Scenario: verify That The Logo Display On HomePage
    Given I am on HomePage
    When Login To The application with username "Admin" and password "admin123"
    Then Verify Logo is Displayed

  @author_JigarPatel  @regression
  Scenario: verify User Should LogOut SuccessFully
    Given I am on HomePage
    When Login To The application with username "Admin" and password "admin123"
    And Click on User Profile logo
    And Mouse hover on Logout and click
    Then Verify the text "Login" is displayed

  @author_JigarPatel @regression
  Scenario Outline: Verify Error Message With Invalid Credentials
    Given I am on HomePage
    When Enter Username "<username>"
    And Enter Password "<password>"
    And Click on Login Button
    Then Verify Error message "<errorMessage>" as per username "<username>" and password "<password>"
    Examples:
      | username            | password  | errorMessage        |
      |                     |           | Required            |
      | prime1042@gmail.com |           | Required            |
      |                     | Prime@123 | Required            |
      | prime1042@gmail.com | Prime@123 | Invalid credentials |
