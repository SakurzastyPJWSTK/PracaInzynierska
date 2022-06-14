class GuidePage {
    get btnDownload() {
        return $('=Download');
    }

    get userNameField() {
        return $('#gated-full-name-1');
    }

    get userEmailField() {
        return $('#gated-email-address');
    }

    get userJobTitleField() {
        return $('#gated-title');
    }

    get userCompanyField() {
        return $('#gated-company');
    }

    get btnSubmit() {
        return $("[type='submit']");
    }

    async setUserName(userName) {
        await this.userNameField.clearValue();
        await this.userNameField.setValue(userName);
    }

    async setUserEmail(userEmail) {
        await this.userEmailField.clearValue();
        await this.userEmailField.setValue(userEmail);
    }

    async setUserJobTitle(userTitle) {
        await this.userJobTitleField.clearValue();
        await this.userJobTitleField.setValue(userTitle);
    }

    async setUserCompany(userCompany) {
        await this.userCompanyField.clearValue();
        await this.userCompanyField.setValue(userCompany);
    }


}

export default new GuidePage();