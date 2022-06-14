*** Settings ***
Library  SeleniumLibrary
Variables  ../TestData/Common.py
Variables   ../Locators/Locators.py

*** Keywords ***
Check Title Page
    Title Should Be    ${LoginPageTitle}

Input Username
    [Arguments]  ${username}
    Input Text    ${UserEmailField}    ${username}

Input Password
    [Arguments]  ${password}
    Input Text    ${UserPasswordField}    ${password}

Click Submit Button
    Click Button    ${SubmitButton}