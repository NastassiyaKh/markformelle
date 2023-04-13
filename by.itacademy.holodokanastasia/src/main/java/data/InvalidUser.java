package data;

import com.github.javafaker.Faker;

public class InvalidUser {
    static Faker faker = new Faker();
    public static final String EMAIL_INVALID = faker.internet().emailAddress();
    public static final String PASSWORD_INVALID = faker.internet().password(6, 16);
    public static final String ERROR_MESSAGE = "Неверный Email или пароль.";
}
