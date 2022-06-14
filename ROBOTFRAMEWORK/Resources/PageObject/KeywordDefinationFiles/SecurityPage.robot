*** Settings ***
Library  SeleniumLibrary
Variables  ../TestData/Common.py
Variables  ../Locators/Locators.py

*** Keywords ***
Check Title Page
    Title Should Be    ${SecurityPageTitle}

Click Download Guide Button
    Click Element    ${DownloadGuideLink}