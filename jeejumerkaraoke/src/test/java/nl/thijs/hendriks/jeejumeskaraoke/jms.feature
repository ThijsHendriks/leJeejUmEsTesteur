Feature: is the JMS message send

  Background:
    * url 'http://localhost:8080'
		* def QueueConsumer = Java.type('nl.thijs.hendriks.jeejumeskaraoke.QueueConsumer')
		* def queue = new QueueConsumer('mailbox')

  Scenario: send the message to the JMS Queue
    Given path 'sendemail'
    And params { message: 'Sillie' }
    When method get
    Then status 200
    And def message = queue.waitForNextMessage()
		And assert message == 'Sillie'

