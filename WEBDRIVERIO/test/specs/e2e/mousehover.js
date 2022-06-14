import WelcomePage from '../../pages/welcome-page';

describe("Scenariusz testowy dla ruchu myszką", () => {

    it('Rozwinięcie menu Product', async () => {
        //Strona powitalna
        await WelcomePage.open();
        await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
            message: "To nie jest strona powitalna"
        });
        await WelcomePage.expandItems[0].moveTo();
        await expect(await WelcomePage.isMenuProductExpand()).toEqual("true");
    });


    it('Rozwinięcie menu Explore', async () => {
        //Strona powitalna
        await WelcomePage.open();
        await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
            message: "To nie jest strona powitalna"
        });
        await WelcomePage.expandItems[1].moveTo();
        await expect(await WelcomePage.isMenuExploreExpand()).toEqual("true");
    });

    it('Rozwinięcie menu Pricing', async () => {
        //Strona powitalna
        await WelcomePage.open();
        await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
            message: "To nie jest strona powitalna"
        });
        await WelcomePage.expandItems[2].moveTo();
        await expect(await WelcomePage.isMenuPricingExpand()).toEqual("true");
    });

});