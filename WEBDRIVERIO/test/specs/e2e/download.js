import WelcomePage from '../../pages/welcome-page';
import SecurityPage from '../../pages/security-page';
import GuidePage from '../../pages/guide-page';
import {
    userName,
    userEmail,
    userJob,
    userCompany
} from '../../data/downloadData';

describe('Scenariusz testowy dla downloadu plików', () => {
    it('Pobranie pliku pdf', async () => {
        //Strona powitalna
        await WelcomePage.open();
        await expect(browser).toHaveTitle('GitHub: Where the world builds software · GitHub', {
            message: "To nie jest strona powitalna"
        });
        await WelcomePage.linkSecurityPage.click();

        //Strona security
        await expect(browser).toHaveTitle('Features · Security · GitHub', {
            message: "To nie jest strona security"
        });
        await SecurityPage.btnDownloadGuide.click();

        //Strona z guidem
        await expect(browser).toHaveTitle('Application Security explained: Downloadable guide to learn how to put the developer first - GitHub Resources', {
            message: "To nie jest strona z guidem"
        });
        await GuidePage.userNameField.scrollIntoView();
        await GuidePage.setUserName(userName);
        await GuidePage.setUserEmail(userEmail);
        await GuidePage.setUserJobTitle(userJob);
        await GuidePage.setUserCompany(userCompany);
        await GuidePage.btnSubmit.click();
        await GuidePage.btnDownload.click();
    });
});