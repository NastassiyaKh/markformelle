package api;

import data.InvalidUser;
import data.ValidUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

public class APITest {

    @BeforeEach
    public void warmUp() {
        baseURI = HomePage.URL;
    }

    @Test
    @DisplayName("website access check")
    public void testGetRequest() {
        when().
                get().
        then().
                statusCode(200);
    }

    @Test
    @DisplayName("verification of user authorization with invalid data")
    public void testPostRequestAuthorizationWithInvalidData() {
        given().
                contentType("multipart/form-data").
                multiPart("USER_LOGIN", InvalidUser.EMAIL_INVALID).
                multiPart("USER_PASSWORD", InvalidUser.PASSWORD_INVALID).
                multiPart("backurl", "/search/").
                multiPart("AUTH_FORM", "Y").
                multiPart("TYPE", "AUTH").
        when().
                post("/ajax/auth_ajax.php").
        then().
                body(containsString(InvalidUser.ERROR_MESSAGE));
    }

    @Test
    @DisplayName("verification of user authorization with valid data")
    public void testPostRequestAuthorizationWithValidData() {
        given().
                contentType("multipart/form-data").
                multiPart("USER_LOGIN", ValidUser.EMAIL_VALID).
                multiPart("USER_PASSWORD", ValidUser.PASSWORD_VALID).
                multiPart("backurl", "/search/").
                multiPart("AUTH_FORM", "Y").
                multiPart("TYPE", "AUTH").
        when().
                post("/ajax/auth_ajax.php").
        then().
                body(containsString(ValidUser.PROFILE_NAME));
    }
}
