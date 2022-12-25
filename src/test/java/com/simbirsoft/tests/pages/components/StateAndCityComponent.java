package com.simbirsoft.tests.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    public void SelectState(String state) {
        $("#state").click();
        $("#state").$(byText(state)).click();

    }

    public void SelectCity(String city) {
        $("#city").click();
        $("#city").$(byText(city)).click();
    }
}
