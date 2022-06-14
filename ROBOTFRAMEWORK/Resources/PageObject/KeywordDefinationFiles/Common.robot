*** Settings ***
Library  SeleniumLibrary
Variables  ../TestData/Configuration.py

*** Keywords ***
Suite setup
    Set Selenium Implicit Wait    10
    Open Browser   about:blank  ${Browser}
    Maximize Browser Window

Suite teardown
    Close Browser