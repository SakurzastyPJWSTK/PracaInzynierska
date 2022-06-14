const {
    Given,
    When,
    Then
} = require('@wdio/cucumber-framework');

import WelcomePage from '../pageobjects/welcome-page';
import LoginPage from '../pageobjects/login-page';

Given(/^I am on the login page/, async () => {
    await WelcomePage.open();
    await WelcomePage.btnSignIn.click();
});

When(/^I login with correct login: (.+) and password: (.+)$/, async (username, password) => {
    await LoginPage.login(username, password);
});

Then(/^I should be successfully logged in/, async () => {
    await expect(browser).toHaveTitle('GitHub', {
        message: "To nie jest strona domowa"
    });
});