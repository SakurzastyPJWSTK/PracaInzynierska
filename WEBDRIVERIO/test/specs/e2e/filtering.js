const {
    getData
} = require("../../utils/dataprovider");

import WelcomePage from '../../pages/welcome-page';
import ResultPage from '../../pages/result-page';
import {
    phrase
} from '../../data/filteringData';

let data = getData('test/data/data.xlsx', 'filter');

describe('Scenariusz testowy dla filtrowania', () => {
    data.forEach(({
        A
    }) => {
        it('Filtrowanie za pomocą słów kluczowych', async () => {
            //Strona powitalna
            await WelcomePage.open();
            await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
                message: "To nie jest strona powitalna"
            });
            await WelcomePage.setSearchPhraseAndEnter(phrase);

            //Strona z wynikami
            await expect(browser).toHaveTitleContaining(phrase, {
                message: "To nie jest strona z wynikami"
            });
            await expect(await ResultPage.resultList.length).toBeGreaterThan(0);
            await ResultPage.clickChoosenFilterItem(A);
            await expect(browser).toHaveUrlContaining(A, {
                message: "URL strony z filtrami nie jest poprawny"
            });
            const list = await ResultPage.getFilteredResultProgrammingLanguageList(A);
            await expect(list.length).toEqual(10, {
                message: "Niepoprawna liczba wyników"
            });
        });
    });
});