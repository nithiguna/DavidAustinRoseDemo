@DavidRegister
Feature: Register Functionality

  #@RegisterPage @DavidRegTest_001
  #Scenario: Successful navigate to Registration Page
   # Given The User is on the Home Page
     # When The User clicks on the Register link
  #  When The User enter valid username and password confirmpassword from sheet "RegisterPage"
  #  Then The User should get navigated to Login Page
#
    
    #@Registration
#Feature: DS Portal Register Functionality

    #Given The User navigates to the Registration page
    #When The User enter valid username and password then confirmPassword from sheet "RegisterPage"
    #Then The User should get navigated to Login Page

 
    
    
  #@LoginCredentials @LoginDavidTC_001
  #Scenario: Validate the login with valid credentials
    #Given The User is on the login page
    #When The User enters the valid username and password "LoginCredentials"
    #Then The User get navigated to home page and successfully logged in
 
 
 
  #@RegisterValidCredentials @RegistrationTest001
  #Scenario: Successful Register with valid Credential
    #Given The User navigates to the Registration page
    #When The User enter valid username and password then confirmPassword from sheet "RegisterPage"
    #Then The User should get navigated to Login Page

  #@RegisterInvalidCredentials @RegistrationTest002
  #Scenario Outline: Unsuccessful Register with Invalid Credentials
    #Given The User navigates to the Registration page
    #When The User enter Invalid username and password then confirmPassword from sheet "<sheetName>" and <rowNumber> and click register button
    #Then The User validate the Excepted Output for Registration Page
#
    #Examples: 
      #| sheetName    | rowNumber |
      #| RegisterPage |         1 |
      #| RegisterPage |         2 |
      #| RegisterPage |         3 |
      #| RegisterPage |         4 |
      #| RegisterPage |         5 |
      #| RegisterPage |         6 |
      #| RegisterPage |         7 |
      #| RegisterPage |         8 |
 
  @RegisterInvalidCredentials @RegistrationTest002
  Scenario Outline: Unsuccessful Register with Invalid Credentials
   # Given The User navigates to the Registration page
     Given The User is on the Home Page
   # When The User enter Invalid username and password then confirmPassword from sheet "<sheetName>" and <rowNumber> and click register button
      When The User enters the Invalid username "<sheetName>" and Invalid password and clicks on Register button <rowNumber>
      Then The User get the suggested message for to get the successful Registration Page

    Examples: 
      | sheetName    | rowNumber |
      | RegisterPage |         1 |
      | RegisterPage |         2 |
      | RegisterPage |         3 |
      | RegisterPage |         4 |
      | RegisterPage |         5 |
      | RegisterPage |         6 |
      | RegisterPage |         7 |
      | RegisterPage |         8 |
    