*** Settings ***
Library  SeleniumLibrary
Variables  ../TestData/Common.py

*** Keywords ***
Check Title Page
    Title Should Be    ${HomePageTitle}
