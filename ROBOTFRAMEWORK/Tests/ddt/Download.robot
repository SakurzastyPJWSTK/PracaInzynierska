*** Settings ***
Library  SeleniumLibrary
Resource  ../../Resources/PageObject/KeywordDefinationFiles/Common.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/WelcomePage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/SecurityPage.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/GuidePage.robot
Variables  ../../Resources/PageObject/TestData/Download.py
Suite Setup  Suite setup
Suite Teardown  Suite teardown

*** Test Cases ***
Download PDF Guide
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Click Security Page Link
    SecurityPage.Check Title Page
    SecurityPage.Click Download Guide Button
    GuidePage.Check Title Page
    GuidePage.Set User Name    ${name}
    GuidePage.Set User Email    ${email}
    GuidePage.Set User Job Title    ${job}
    GuidePage.Set User Company    ${company}
    GuidePage.Click Submit Button
    GuidePage.Click Download Button




