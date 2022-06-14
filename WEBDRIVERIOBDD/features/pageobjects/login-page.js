class LoginPage {
    get userLoginField() {
        return $('#login_field');
    }

    get userPasswordField() {
        return $('#password');
    }


    get btnLogin() {
        return $('.btn-primary');
    }

    async login(username, password) {
        await this.userLoginField.setValue(username);
        await this.userPasswordField.setValue(password);
        await this.btnLogin.click();
    }

}

export default new LoginPage();