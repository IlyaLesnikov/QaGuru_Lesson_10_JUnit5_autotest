package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AdvancedSearchPage {
    private final SelenideElement findFilmField = $("#find_film");
    private final SelenideElement searchButton = $("[class*='submit ']");
    public AdvancedSearchPage fillFieldFindFilm(String name) {
        findFilmField.setValue(name);

        return this;
    }
    public void pressButtonSearch() {
        searchButton.click();
    }
}
