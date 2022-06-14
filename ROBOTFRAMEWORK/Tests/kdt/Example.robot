*** Settings ***
Library    SeleniumLibrary
Suite Setup     Suite start
Suite Teardown  Suite shutdown

*** Variables ***
${Browser}    Chrome
${URL}    https://github.com/

*** Test Cases ***
Login with proper credentials
    Open Browser  ${URL}  ${Browser}
    Maximize Browser Window
    Title Should Be    GitHub: Where the world builds software · GitHub
    Click Element    link:Sign in
    Title Should Be    Sign in to GitHub · GitHub
    Enter Credentials  test@test.com  Password1
    Click Button    name:commit
    Title Should Be    GitHub

*** Keywords ***
Suite start
    Set Selenium Implicit Wait    10

Suite shutdown
    Close Browser

Enter Credentials
    [Arguments]  ${username}  ${password}
    Input Text    id:login_field  ${username}
    Input Password    id:password   ${password}
