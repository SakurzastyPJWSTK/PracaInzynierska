*** Settings ***
Library  SeleniumLibrary
Library    Collections
Variables  ../TestData/Configuration.py
Variables  ../TestData/Common.py
Variables  ../Locators/Locators.py

*** Keywords ***
Open Welcome Page
    Go To    ${URL}
    
Check Title Page
    Title Should Be    ${WelcomePageTitle}

Click Sign In Button
    Click Element    ${SignInButton}

Get Menu Items
    @{list}=  Get WebElements    ${ExpandItemsBar}
    [Return]  @{list}

Get Menu Product
    @{list}=  Get Menu Items
    [Return]  ${list}[0]

Get Menu Explore
    @{list}=  Get Menu Items
    [Return]  ${list}[1]

Get Menu Pricing
    @{list}=  Get Menu Items
    [Return]  ${list}[2]

Mouse Over Product Menu
    @{list}=  Get Menu Items
    Mouse Over    ${list}[0]

Mouse Over Explore Menu
    @{list}=  Get Menu Items
    Mouse Over    ${list}[1]

Mouse Over Pricing Menu
    @{list}=  Get Menu Items
    Mouse Over    ${list}[2]

Enter Search Phrase
    [Arguments]  ${keyword}
    Clear Element Text    ${SearchField}
    Input Text    ${SearchField}    ${keyword}
    Press Keys    ${SearchField}    ENTER

Click Security Page Link
    Click Link    ${SecurityPageLink}