#Author: Pham Xuan
@CatApi
Feature: Login Api Main Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have url and Method and request body
      | Method | URL                                                                                         | RequestBodyName                      |
      | POST   | https://gwint-apidev.seabank.com.vn:9443/seabank/seabank-internal/api/v1/k8s/authen/process | \\LoginAPi\\LoginApiRequestBody.json |
    When I send request
    Then I check <StatusCode> correctly
    #And The response returns token

    Examples: 
      | StatusCode |
      |        200 |
