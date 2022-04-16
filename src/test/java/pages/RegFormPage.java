package pages;

import pages.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormPage {
    Calendar calendar = new Calendar();

    //locators


    //actions
    public RegFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");
        return this;
    }

    public RegFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegFormPage setNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegFormPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegFormPage setHobby(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegFormPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();
        return this;
    }

    public RegFormPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();
        return this;
    }

    public RegFormPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegFormPage setIMG(String imgPath) {
        $("#uploadPicture").uploadFromClasspath(imgPath);
        return this;
    }

    public RegFormPage submit() {
        $("#submit").click();
        return this;
    }

    public RegFormPage checkResult(String value, String key) {
    $(" .table-responsive").$(byText(value))
            .parent().shouldHave(text(key));
        return this;
    }

}
