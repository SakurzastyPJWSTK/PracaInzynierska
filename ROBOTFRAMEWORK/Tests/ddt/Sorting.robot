*** Settings ***
Library  SeleniumLibrary
Library  DataDriver  ../../Resources/PageObject/TestData/data.xlsx  sheet_name=sort
Resource  ../../Resources/PageObject/KeywordDefinationFiles/Common.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/WelcomePage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/ResultPage.robot
Suite Setup  Suite setup
Suite Teardown  Suite teardown
Test Template  Valid Sort Scenarios

*** Variables ***
${phrase}  bdd

*** Test Cases ***
Sort test on mode: ${sortBy} ${key1} ${key2}

*** Keywords ***
Valid Sort Scenarios
    [Arguments]  ${sortBy}  ${key1}  ${key2}
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Enter Search Phrase    ${phrase}
    ResultPage.Check Title Page    ${phrase}
    ResultPage.Click Sort Menu
    ResultPage.Click Choosen Sort Menu Item    ${sortBy}
    Location Should Contain    ${key1}
    Location Should Contain    ${key2}


