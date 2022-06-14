class WelcomePage {
    async open() {
        await browser.url('/');
    }

    get expandItems() {
        return $$('.HeaderMenu-details.details-overlay.details-reset.width-full');
    }

    get btnSignIn() {
        return $('=Sign in');
    }

    get linkSecurityPage() {
        return $('=Learn more about advanced security');
    }

    get searchField() {
        return $('[name="q"]');
    }

    async setSearchPhraseAndEnter(phrase) {
        await this.searchField.clearValue();
        await this.searchField.setValue(`${phrase}\n`);
    }

    async isMenuProductExpand() {
        return await this.expandItems[0].getAttribute('open')
    }

    async isMenuExploreExpand() {
        return await this.expandItems[1].getAttribute('open')
    }

    async isMenuPricingExpand() {
        return await this.expandItems[2].getAttribute('open')
    }
}

export default new WelcomePage();