Feature: Launch the applications

@Test
Scenario Outline: User to launch the applications using valid details
    Given launch the browser
    And launch the application URLs "<url>"

    Examples: 
      | 	       url            |
      |  https://www.amazon.in/ |
      |  https://www.google.com/|
