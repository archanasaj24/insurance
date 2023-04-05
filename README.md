# insurance
This application is developed using Spring Boot, MySql. To create spring boot project Spring Initializer is used and developed in Spring Tool Suit4.
In this project there are 3 models Client, InsurancePolicy, Claim. CRUD operation performs on these modules. I use Bean validation for validation, mapping and Exception handling.

Project Structure
Insurance
  com.project.insurance:
    -com.project.insurance.controller
       * ClaimController.java
       * ClientController.java
       * InsurancePolicyController.java
     -com.project.insurance.dao(interfaces)
       * ClaimRepository.java
       *  ClientRepository.java
       *  InsurancePolicyRepository.java
     -com.project.insurance.exception        
       * ErrorDetails.java
       * GlobalExceptionHandler.java
       * ResourceNotFoundException.java
      -com.project.insurance.model
       * Claim.java
       * Client.java
       * InsurancePolicy.java
      -com.project.insurance.service
       * ClaimService.java (interface)
       * ClaimServiceImpl.java(implementation class)
       * ClientService.java (interface)
       * ClientServiceImpl.java(implementation class)
       * InsurancePolicyService.java (interface)
       * InsurancePolicy.java(implementation class)
        
        To run project:
        Use Postman and send url according to request
        For example
        If want to add new Client
         1 Select POST method
         2 send url: POST/api/clients
         
        Featurs:
        1 Can do CRUD (Create, Retrive, Update, Delete) operation
        2 Can retrive one specific data or all data from database
        3 Fields are validate according to the properties e.g. contact accept only 10 digits.
