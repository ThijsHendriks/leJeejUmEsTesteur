Feature: is the JMS message send

  Background:
    * url 'http://localhost:8080'

  Scenario: send the message to the JMS Queue
    Given path 'sendemail'
    When method get
    Then status 200
