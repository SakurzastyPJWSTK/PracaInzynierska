*** Settings ***
Library  SeleniumLibrary
Library  DataDriver  ../../Resources/PageObject/TestData/data.xlsx  sheet_name=filter
Resource  ../../Resources/PageObject/KeywordDefinationFiles/Common.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/WelcomePage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/ResultPage.robot
Suite Setup  Suite setup
Suite Teardown  Suite teardown
Test Template  Valid Filtr Scenarios

*** Variables ***
${phrase}  gradle

*** Test Cases ***
Filtering test with filtr: ${filtr}

*** Keywords ***
Valid Filtr Scenarios
    [Arguments]  ${filtr}
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Enter Search Phrase    ${phrase}
    ResultPage.Check Title Page    ${phrase}
    ResultPage.Click Choosen Filter Menu Item    ${filtr}
    Location Should Contain    ${filtr}
    @{list}=  ResultPage.Get Filtered Result Programming Language List    ${filtr}
    ${listSize}=  Get Length    ${list}
    Should Be Equal As Integers    10    ${listSize}


