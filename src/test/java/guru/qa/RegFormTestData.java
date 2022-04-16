package guru.qa;

import com.github.javafaker.Faker;

import static java.lang.String.format;

public class RegFormTestData {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = format("%s %s", firstName, lastName),
            email = faker.internet().emailAddress(),
            userNumber = RegFormRandomUtils.getPhoneNumber(10),
            gender = RegFormRandomUtils.getGender(),
            subject = "Hindi",
            hobby = RegFormRandomUtils.getHobby(),
            year = RegFormRandomUtils.getRandomYear(1900,2100),
            day = RegFormRandomUtils.getRandomDay(1,28),
            month = RegFormRandomUtils.getRandomMonth(),
            birthday = format(day, month, year),
            address = faker.address().streetAddress(),
            state = "Uttar Pradesh",
            city = "Agra",
            stateCity = format("%s %s", state, city),
            img = "image.jpg";
}
