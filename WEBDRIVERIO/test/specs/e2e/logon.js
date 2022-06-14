const {
    getData
} = require("../../utils/dataprovider");

let daneLogowania = getData('test/data/data.xlsx', 'login');

import WelcomePage from '../../pages/welcome-page';
import LoginPage from '../../pages/login-page';

describe("Scenariusz testowy dla logowania", () => {

    //konieczne usunięcie cookies
    afterEach(async () => {
        await browser.deleteCookies();
    })

    //pętla dla testów
    daneLogowania.forEach(({
        A,
        B
    }) => {
        it('Logowanie za pomocą poprawnych danych', async () => {
            //strona powitalna
            await WelcomePage.open();
            await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
                message: "To nie jest strona powitalna"
            });
            await WelcomePage.btnSignIn.click();

            //Strona logowania
            await expect(browser).toHaveTitle('Sign in to GitHub · GitHub', {
                message: "To nie jest strona logowania"
            });
            await LoginPage.userLoginField.setValue(A);
            await LoginPage.userPasswordField.setValue(B);
            await LoginPage.btnLogin.click();

            //Strona domowa
            await expect(browser).toHaveTitle('GitHub', {
                message: "To nie jest strona domowa"
            });
        });
    });
});