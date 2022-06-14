describe("Testy logowania", () => {
    it('Logowanie za pomocą poprawnych danych', async () => {
        //Strona powitalna
        await browser.url("https://github.com/");
        await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
            message: "To nie jest strona powitalna"
        });
        await $('=Sign in').click();

        //Strona logowania
        await expect(browser).toHaveTitle('Sign in to GitHub · GitHub', {
            message: "To nie jest strona logowania"
        });
        await $('#login_field').setValue('Sakurzasty');
        await $('#password').setValue('VmSv8[].7BJ\\/52W4{WsZl%;');
        await $('.btn-primary').click();

        //Strona domowa
        await expect(browser).toHaveTitle('GitHub', {
            message: "To nie jest strona domowa"
        });
    })
});