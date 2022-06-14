*** Settings ***
Library  SeleniumLibrary
Variables  ../TestData/Common.py
Variables  ../Locators/Locators.py


*** Keywords ***
Check Title Page
    Title Should Be    ${GuidePageTitle}

Set User Name
    [Arguments]  ${text}
    Clear Element Text    ${UserNameField}
    Input Text    ${UserNameField}    ${text}

Set User Email
    [Arguments]  ${text}
    Clear Element Text    ${UserEmailAdressField}
    Input Text    ${UserEmailAdressField}    ${text}

Set User Job Title
    [Arguments]  ${text}
    Clear Element Text    ${UserJobTitleField}
    Input Text    ${UserJobTitleField}    ${text}

Set User Company
    [Arguments]  ${text}
    Clear Element Text    ${UserCompanyField}
    Input Text    ${UserCompanyField}    ${text}
    
Click Submit Button
    Set Focus To Element    ${SubmitGuideButton}
    Sleep    1
    Click Element    ${SubmitGuideButton}

Click Download Button
    Set Focus To Element    ${DownloadGuideButton}
    Sleep    1
    Click Element    ${DownloadGuideButton}
