const {
    getData
} = require("../../utils/dataprovider");

import WelcomePage from '../../pages/welcome-page';
import ResultPage from '../../pages/result-page';
import {
    phrase
} from '../../data/sortingData';

let data = getData('test/data/data.xlsx', 'sort');

describe('Scenariusz testowy dla sortowania', () => {

    data.forEach(({
        A,
        B,
        C
    }) => {
        it('Sortowanie za pomocą słów kluczowych', async () => {
            //Strona powitalna
            await WelcomePage.open();
            await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
                message: "To nie jest strona powitalna"
            });
            await WelcomePage.setSearchPhraseAndEnter(phrase);

            //Strona z wynikami
            await expect(browser).toHaveTitleContaining("Search", {
                message: "To nie jest strona z wynikami"
            });
            await ResultPage.sortMenu.click();
            await ResultPage.clickChoosenSortMenuItem(A);
            await expect(browser).toHaveUrlContaining(B, {
                message: "URL strony z sortowaniem nie jest poprawny, brak: " + B
            });
            await expect(browser).toHaveUrlContaining(C, {
                message: "URL strony z sortowaniem nie jest poprawny, brak: " + C
            });
        });
    });
});