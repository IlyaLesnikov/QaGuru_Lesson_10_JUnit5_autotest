package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AssertComponents {
    private final SelenideElement informationContent = $("[data-test-id='encyclopedic-table']");
    private final SelenideElement chancesAreYoureLookingForElement = $("[class='element most_wanted'] [class='info']");
    public AssertComponents assertInformationContent(String nameOfInformation, String value) {
        informationContent.$(byText(nameOfInformation)).sibling(0).shouldHave(text(value));

        return this;
    }
    public void assertAdvancedSearchResult(String name) {
        chancesAreYoureLookingForElement.shouldHave(text(name));
    }
}
