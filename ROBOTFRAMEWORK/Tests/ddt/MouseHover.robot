*** Settings ***
Library  SeleniumLibrary
Resource  ../../Resources/PageObject/KeywordDefinationFiles/Common.robot
Resource  ../../Resources/PageObject/KeywordDefinationFiles/WelcomePage.robot
Suite Setup  Suite setup
Suite Teardown  Suite teardown

*** Test Cases ***
Expand Menu Product
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Mouse Over Product Menu
    ${elem}=  WelcomePage.Get Menu Product
    Element Attribute Value Should Be    ${elem}    open    true

Expand Menu Explore
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Mouse Over Explore Menu
    ${elem}=  WelcomePage.Get Menu Explore
    Element Attribute Value Should Be    ${elem}    open    true

Expand Menu Pricing
    WelcomePage.Open Welcome Page
    WelcomePage.Check Title Page
    WelcomePage.Mouse Over Pricing Menu
    ${elem}=  WelcomePage.Get Menu Pricing
    Element Attribute Value Should Be    ${elem}    open    true


