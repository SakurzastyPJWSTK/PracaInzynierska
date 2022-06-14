const {
    getData
} = require("../../utils/dataprovider");

let daneLogowania = getData('test/data/data.xlsx', 'login');


describe("Testy logowania", () => {

    //pętla dla testów
    daneLogowania.forEach(({
        A,
        B
    }) => {
        it('Logowanie za pomocą poprawnych danych', async () => {
            //Strona powitalna
            await browser.navigateTo("https://github.com/");
            await browser.url("https://github.com/");
            await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
                message: "To nie jest strona powitalna"
            });
            await $('=Sign in').click();

            //Strona logowania
            await expect(browser).toHaveTitle('Sign in to GitHub · GitHub', {
                message: "To nie jest strona logowania"
            });
            await $('#login_field').setValue(A);
            await $('#password').setValue(B);
            await $('.btn-primary').click();

            //Strona domowa
            await expect(browser).toHaveTitle('GitHub', {
                message: "To nie jest strona domowa"
            });

            //konieczne usunięcie cookies
            await browser.deleteCookies();
        });
    });
});