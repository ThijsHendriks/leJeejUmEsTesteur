Feature: is the JMS message send

  Background:
    * url 'http://localhost:8080'
		* def QueueConsumer = Java.type('nl.thijs.hendriks.jeejumeskaraoke.QueueConsumer')
		* def queue = new QueueConsumer(queueName)

  Scenario: send the message to the JMS Queue
    Given path 'sendemail'
    When method get
    Then status 200
    and queue.waitForNextMessage() == 'Hello'
