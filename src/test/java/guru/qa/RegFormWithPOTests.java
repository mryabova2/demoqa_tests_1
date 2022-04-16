package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegFormPage;



public class RegFormWithPOTests {
    RegFormPage regFormPage = new RegFormPage();
    RegFormTestData regFormTestData = new RegFormTestData();


    @BeforeAll
    static void ChromeSetUp () {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void closeChrome (){
        WebDriverRunner.closeWindow();
    }


    @Test
    void fillFormTest () {
        regFormPage.openPage()
                .setFirstName(regFormTestData.firstName)
                .setLastName(regFormTestData.lastName)
                .setEmail(regFormTestData.email)
                .setGender(regFormTestData.gender)
                .setNumber(regFormTestData.userNumber)
                .setBirthDay(regFormTestData.day,regFormTestData.month,regFormTestData.year)
                .setSubject(regFormTestData.subject)
                .setHobby(regFormTestData.hobby)
                .setIMG(regFormTestData.img)
                .setAddress(regFormTestData.address)
                .setState(regFormTestData.state)
                .setCity(regFormTestData.city)
                .submit()

                .checkResult("Student Name",regFormTestData.fullName)
                .checkResult("Student Email",regFormTestData.email)
                .checkResult("Gender",regFormTestData.gender)
                .checkResult("Mobile",regFormTestData.userNumber)
                .checkResult("Date of Birth",regFormTestData.birthday)
                .checkResult("Subjects",regFormTestData.subject)
                .checkResult("Hobbies",regFormTestData.hobby)
                .checkResult("Picture", regFormTestData.img)
                .checkResult("Address",regFormTestData.address)
                .checkResult("State and City",regFormTestData.stateCity);
    }
}
