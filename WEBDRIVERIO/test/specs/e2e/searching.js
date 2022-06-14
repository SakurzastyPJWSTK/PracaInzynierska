const {
    getData
} = require("../../utils/dataprovider");

import WelcomePage from '../../pages/welcome-page';
import ResultPage from '../../pages/result-page';

let data = getData('test/data/data.xlsx', 'search');

describe('Scenariusz testowy dla wyszukiwania', () => {

    data.forEach(({
        A
    }) => {
        it('Wyszukiwanie za pomocą słów kluczowych', async () => {
            //Strona powitalna
            await WelcomePage.open();
            await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
                message: "To nie jest strona powitalna"
            });
            await WelcomePage.setSearchPhraseAndEnter(A);

            //Strona z wynikami
            await expect(browser).toHaveTitleContaining(A, {
                message: "To nie jest strona z wynikami"
            });
            await expect(await ResultPage.resultList.length).toBeGreaterThan(0, {
                message: "Lista wyników wyszukiwania jest pusta"
            });
            await expect(await ResultPage.isKeywordVisibleInResultList(A)).toEqual(true, {
                message: "Pośród wyników wyszukiwania nie ma poszukiwanego keyworda"
            });
        });
    });
});