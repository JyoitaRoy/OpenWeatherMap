#Author: jyoita.roy@capgemini.com

@tag
Feature: OpenWeatherMap api 
  I want to use this template for my feature file


  Scenario: user post the details
    Given The url
    When I Post the request and the details successfully stored in DB
     
  Scenario: user get the details
    Given The url
    When I Get the request and  I able to see the details
    
  Scenario: User delete the details
    Given The url
    When I Delete the request and the details successfully deleted
   
