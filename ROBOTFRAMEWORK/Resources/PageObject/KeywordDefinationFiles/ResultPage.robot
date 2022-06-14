*** Settings ***
Library  SeleniumLibrary
Library    Collections
Variables  ../Locators/Locators.py

*** Keywords ***
Check Title Page
    [Arguments]  ${keyword}
    Title Should Be    Search · ${keyword} · GitHub

Get Result List
    @{list}=  Get WebElements    ${ResultList}
    [Return]  @{list}

Check Is Keyword Visible In Result List
    [Arguments]  ${keyword}
    ${var}=  Set Variable  false
    @{list}=  Get Result List
    FOR    ${element}    IN    @{list}
        ${text}=  Get Text    ${element}
        ${contains}=  Evaluate    "${keyword}" in """${text}"""
        IF    ${contains}
             ${var}=  Set Variable  true
             BREAK
        END
    END
    [Return]  ${var}

Click Sort Menu
    Click Element    ${SortMenu}

Get Sort Menu Item List
    @{list}=  Get WebElements    ${SortMenuItemList}
    [Return]  @{list}

Click Choosen Sort Menu Item
    [Arguments]  ${menuItem}
    @{list}=  Get Sort Menu Item List
        FOR    ${element}    IN    @{list}
            ${text}=  Get Text    ${element}
            ${contains}=  Evaluate    "${menuItem}" in """${text}"""
            IF    ${contains}
                 Click Element    ${element}
                 BREAK
            END
        END

Get Filter Menu Item List
    @{list}=  Get WebElements    ${FilterMenuItemList}
    [Return]  @{list}

Click Choosen Filter Menu Item
    [Arguments]  ${menuItem}
    @{list}=  Get Filter Menu Item List
        FOR    ${element}    IN    @{list}
            ${text}=  Get Text    ${element}
            ${contains}=  Evaluate    "${menuItem}" in """${text}"""
            IF    ${contains}
                 Click Element    ${element}
                 BREAK
            END
        END

Get Filtered Result Programming Language List
    [Arguments]  ${name}
    Reload Page
    @{list}=  Get WebElements    xpath://*[@itemprop="programmingLanguage" and text()="${name}"]
    [Return]  @{list}