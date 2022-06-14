*** Settings ***
Library  SeleniumLibrary
Library  DataDriver  ../../Resources/PageObject/TestData/data.xlsx  sheet_name=search
Resource  ../../Resources/PageObject/KeywordDefinationFiles/Common.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/WelcomePage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/ResultPage.robot
Suite Setup  Suite setup
Suite Teardown  Suite teardown
Test Template  Valid Search Scenarios

*** Test Cases ***
Search test with keyword: ${keyword}

*** Keywords ***
Valid Search Scenarios
    [Arguments]  ${keyword}
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Enter Search Phrase    ${keyword}
    ResultPage.Check Title Page    ${keyword}
    @{list}=  ResultPage.Get Result List
    ${listSize}=  Get Length    ${list}
    Should Be True    ${listSize}>0
    ${check}=  ResultPage.Check Is Keyword Visible In Result List    ${keyword}
    Should Be Equal    ${check}    true
