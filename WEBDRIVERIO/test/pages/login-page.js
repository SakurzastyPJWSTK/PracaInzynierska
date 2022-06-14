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

}

export default new LoginPage();