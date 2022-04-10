package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {

    @BeforeAll
    static void ChromeSetUp () {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void closeChrome (){
        WebDriverRunner.closeWindow();
    }

    @Test
    void fillFormTest () {
        String firstName = "Ivan";
        String lastName = "Petrov";
        String email = "ivanp@mail.ru";
        String userNumber = "1234567890";
        String gender = "Male";
        String subject = "Hindi";
        String hobby = "Reading";
        String year = "2002";
        String month = "April";
        String day = "2";
        String address = "City, street, 2";
        String state = "Uttar Pradesh";
        String city = "Agra";

        open("/automation-practice-form");
        executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(userNumber);
        $(byText(gender)).click();
        $("#dateOfBirthInput").click();
        $(" .react-datepicker__year-select").selectOption(year);
        $(" .react-datepicker__month-select").selectOption(month);
        $(byText(day)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $(" .table-responsive  tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text(firstName+" "+lastName));
        $(" .table-responsive  tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text(email));
        $(" .table-responsive  tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text(gender));
        $(" .table-responsive  tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text(userNumber));
        $(" .table-responsive  tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text(day+" "+month+","+year));
        $(" .table-responsive  tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text(subject));
        $(" .table-responsive  tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text(hobby));
        $(" .table-responsive  tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("image.jpg"));
        $(" .table-responsive  tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text(address));
        $(" .table-responsive  tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text(state+" "+city));
    }
}
