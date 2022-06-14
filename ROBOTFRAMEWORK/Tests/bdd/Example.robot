*** Settings ***
Library    SeleniumLibrary
Suite Setup     Suite start
Suite Teardown  Suite shutdown

*** Variables ***
${Browser}    Chrome
${URL}    https://github.com/

*** Test Cases ***
Login with proper credentials
    Given I Am On Login Page
    When I Login With Correct Login And Password  Sakurzasty  VmSv8[].7BJ\\/52W4{WsZl%;
    Then I Should Be Successfully Logged In

*** Keywords ***
Suite start
    Set Selenium Implicit Wait    10
    Open Browser   ${URL}    ${Browser}
    Maximize Browser Window
    Title Should Be    GitHub: Where the world builds software · GitHub

Suite shutdown
    Close Browser

I Am On Login Page
    Click Element    link:Sign in
    Title Should Be    Sign in to GitHub · GitHub

I Login With Correct Login And Password
    [Arguments]  ${username}  ${password}
    Input Text    id:login_field  ${username}
    Input Password    id:password   ${password}
    Click Button    name:commit

I Should Be Successfully Logged In
    Title Should Be    GitHub