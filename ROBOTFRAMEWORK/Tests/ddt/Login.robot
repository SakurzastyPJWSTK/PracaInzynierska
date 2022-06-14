*** Settings ***
Library  SeleniumLibrary
Library  DataDriver  ../../Resources/PageObject/TestData/data.xlsx  sheet_name=login
Resource  ../../Resources/PageObject/KeywordDefinationFiles/Common.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/WelcomePage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/LoginPage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/HomePage.robot
Suite Setup  Suite setup
Suite Teardown  Suite teardown
Test Template  Valid Login Scenarios

*** Test Cases ***
Login with proper credentials ${username} ${password}

*** Keywords ***
Valid Login Scenarios
    [Arguments]  ${username}  ${password}
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Click Sign In Button
    LoginPage.Check Title Page
    LoginPage.Input Username  ${username}
    LoginPage.Input Password  ${password}
    LoginPage.Click Submit Button
    HomePage.Check Title Page
    [Teardown]  Delete All Cookies

