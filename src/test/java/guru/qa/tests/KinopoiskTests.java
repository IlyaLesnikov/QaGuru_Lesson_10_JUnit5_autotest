package guru.qa.tests;

import guru.qa.data.Film;
import guru.qa.pages.AdvancedSearchPage;
import guru.qa.pages.MainPage;
import guru.qa.pages.components.AssertComponents;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;


import static io.qameta.allure.Allure.step;

public class KinopoiskTests extends BaseTest {
    MainPage mP = new MainPage();
    AssertComponents aS = new AssertComponents();
    AdvancedSearchPage aDP = new AdvancedSearchPage();
    @BeforeEach
    protected void openWebCite() {
        step("Открытие главной страницы", () -> mP.openWebSite());
    }
    @AfterEach
    protected void haveANiceDay() {
        System.out.println("Я вывожусь после окончания каждого теста!)");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Бригада",
            "Слово пацана. Кровь на асфальте"
    })
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    @DisplayName("Поик значения")
    protected void openingAContentCard(String name) {
        step("Ввод данных в поле поиска", () -> mP.fillFieldSearch(name));
        step("Открытие карточки значения которое искали", () -> mP.fillValueSearch(name));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data/informationContent.csv")
    @Tag("SMOKE")
    @DisplayName("Проверка информации о контенте")
    protected void verificationOfContentInformation(String name, String year, String platform, String country) {
        step("Ввод данных в поле поиска", () -> mP.fillFieldSearch(name));
        step("Открытие карточки контента которую искали", () -> mP.fillValueSearch(name));
        step("Проверка информации о контенте", () -> {
            aS.assertInformationContent("Год производства", year)
                    .assertInformationContent("Платформа", platform)
                    .assertInformationContent("Страна", country);
        });
    }

    @ParameterizedTest
    @EnumSource(Film.class)
    @Tag("SMOKE")
    @DisplayName("Поиск контента через поиск с помощью enum")
    protected void searchingForContentThrough(Film nameEnum) {
        step("Открытие веб-формы расширенного поиска", () -> mP.openAdvancedSearch());
        step("Заполнение поля 'Искать фильмы:' и нажатие на кнопку 'поиск'", () -> {
            aDP.fillFieldFindFilm(nameEnum.getEurotour())
                    .pressButtonSearch();
            aS.assertAdvancedSearchResult(nameEnum.getFounder());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Не пойман – не вор",
            "Зеленая миля"
    })
    @Tag("SMOKE")
    @DisplayName("Поиск контента через расширенный поиск")
    protected void findingContentThroughAdvancedSearch(String name) {
        step("Открытие веб-формы расширенного поиска", () -> mP.openAdvancedSearch());
        step("Заполнение поля 'Искать фильмы:' и нажатие на кнопку 'поиск'", () -> {
            aDP.fillFieldFindFilm(name)
                    .pressButtonSearch();
            aS.assertAdvancedSearchResult(name);
        });
    }
}
