class ResultPage {
    get filterMenuList() {
        return $$('.filter-item');
    }

    get resultList() {
        return $$('a.v-align-middle');
    }

    get sortMenu() {
        return $('.d-none.d-md-block.mt-2.mt-sm-0.details-reset.details-overlay.select-menu');
    }

    get sortMenuItemList() {
        return $$('.select-menu-item');
    }

    async clickChoosenFilterItem(filter) {
        var list = await this.filterMenuList
        var size = list.length
        for (var i = 0; i < size; i++) {
            var str = await list[i].getText()
            if (str.includes(filter)) {
                await list[i].click()
                break;
            }
        }
    }

    async clickChoosenSortMenuItem(menuItem) {
        var list = await this.sortMenuItemList
        var size = list.length
        for (var i = 0; i < size; i++) {
            var str = await list[i].getText()
            if (str.includes(menuItem)) {
                await list[i].click()
                break;
            }
        }
    }

    async isKeywordVisibleInResultList(keyword) {
        var list = await this.resultList
        var size = list.length
        for (var i = 0; i < size; i++) {
            var str = await list[i].getText()
            if (str.includes(keyword)) {
                return true;
            }
        }
        return false;
    }

    async getFilteredResultProgrammingLanguageList(name) {
        await browser.refresh(); // odświeżenie stanu elementów stron => zgłoszony bug Github
        return await $$(`//*[@itemprop='programmingLanguage' and text()='${name}']`)
    }

}

export default new ResultPage();