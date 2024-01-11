#Author: Pham Xuan
@CatApi
Feature: STO Create And Update Api Main Test

  Scenario Outline: Check response when send request successfully
    Given I have url and Method and request body
      | Method | URL                                        | RequestBodyName                                                |
      | POST   | http://10.6.70.45:8084/STO_API_NEW/process | \\STOCreateAndUpdateApi\\STOCreateAndUpdateApiRequestBody.json |
    When I send request
    Then I check <StatusCode> correctly

    Examples: 
      | StatusCode |
      |        200 |
