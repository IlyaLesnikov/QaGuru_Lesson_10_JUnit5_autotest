package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement fieldSearch = $("[class*='search-form-input__input']");
    private final SelenideElement valueSearch = $("[class*='kinopoisk-header-suggest__groups']");
    private final SelenideElement onlineMovieTheaterTab = $("#suggest-container");
    private final SelenideElement advancedSearch = $("[aria-label='Расширенный поиск']");
    public void openWebSite() {
        open("https://www.kinopoisk.ru/");
    }
    public void fillFieldSearch(String name) {
        fieldSearch.setValue(name);
    }
    public void fillValueSearch(String name) {
        valueSearch.$(byText(name)).click();
    }
    public void openAdvancedSearch() {
        advancedSearch.click();
    }
}
