Feature: Karros Testing
  Scenario: Enter valid email and valid password - TC_LOGIN_001
    Given I navigate to the web application
    And I login with username admin@test.com and password test123
    Then I should see Parent Portal page is displayed
    
  Scenario: Enter valid email and invalid password - TC_LOGIN_002
    Given I navigate to the web application
    And I login with username admin@test.com and password test1234
    Then I should see Parent Portal page is not displayed
    
  Scenario: Enter invalid email and valid password  - TC_LOGIN_003
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test123
    Then I should see Parent Portal page is not displayed
    
  Scenario: Enter invalid email and invalid password - TC_LOGIN_004
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is not displayed
    
  Scenario: Verify logout function - TC_LOGOUT_001
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I sign out the application
    Then I should see login page
    
  Scenario: Verify that filters by Request Status works correctly - TC_FILTER_001
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on Filters button
    And I select Request Status Pending
    And I click Apply Filters button
    And I should see Request Status is Pending
    
  Scenario: Verify that filters by Email works correctly - TC_FILTER_002
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on Filters button
    And I enter email tuan1@gmail.com
    And I click Apply Filters button
    And I should see Requester is tuan1@gmail.com
    
  Scenario: Verify that filters by Student ID works correctly - TC_FILTER_003
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on Filters button
    And I enter Student ID 2664809
    And I click Apply Filters button
    And I should see Student ID is 2664809  
    
  Scenario: Verify that filters by First Name works correctly - TC_FILTER_004
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on Filters button
    And I enter Student First Name Noelle
    And I click Apply Filters button
    And I should see Student First Name is Noelle
    
  Scenario: Verify that filters by Last Name works correctly - TC_FILTER_005
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on Filters button
    And I enter Student Last Name Dallas
    And I click Apply Filters button
    And I should see Student Last Name is Dallas
    
  Scenario: Verify that filters by many conditions works correctly - TC_FILTER_006
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on Filters button
    And I select Request Status Pending
    And I enter email tuan1@gmail.com
		#And I enter Student ID 2664809 
    And I enter Student First Name Noelle
    And I enter Student Last Name Dallas
    And I click Apply Filters button
    Then I should see Request Status is Pending
    Then I should see Requester is tuan1@gmail.com
    Then I should see Student ID is 2664809
    Then I should see Student First Name is Noelle
    Then I should see Student Last Name is Dallas
    
  Scenario: Verify that user can sort by request status header - TC_SORT_001
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on header name Request Status
    And I should see request status with descending order
    And I click on header name Request Status
    And I should see request status with ascending order
    
  Scenario: Verify that user can sort by Date Submitted header - TC_SORT_002
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I should see date submitted with descending order
    And I click on header name Date Submitted
    And I should see date submitted with ascending order
    And I click on header name Date Submitted
    And I should see date submitted with descending order
    
  Scenario: Verify that user can sort by Requester - TC_SORT_003
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on header name Requester
    And I should see requester with descending order
    And I click on header name Requester
    And I should see requester with ascending order
    
  Scenario: Verify that user can sort by First Name - TC_SORT_004
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on header name First Name
    And I should see first name with descending order
    And I click on header name First Name
    And I should see first name with ascending order
    
  Scenario: Verify that user can sort by Last Name - TC_SORT_005
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on header name Last Name
    And I should see last name with descending order
    And I click on header name Last Name
    And I should see last name with ascending order
        
  Scenario: Verify that user can sort by DOB - TC_SORT_006
    Given I navigate to the web application
    And I login with username admin@test.com.vn and password test1234
    Then I should see Parent Portal page is displayed
    And I click on header name DOB
    And I should see date of birthday with descending order
    And I click on header name DOB
    And I should see date of birthday with ascending order
    
######################################################################################
   
  #Scenario: Verify that user can change request status of data - TC_CS_001
    #Given I navigate to the web application
    #And I login with username admin@test.com.vn and password test1234
    #Then I should see Parent Portal page is displayed
    #And I click on header name Last Name
    #And I click on Rejected status of the first record
    #And I change to status of this to Approved status
    #Then I should see status of this is Approved  
    