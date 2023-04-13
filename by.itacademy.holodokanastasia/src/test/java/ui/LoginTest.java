package ui;

import data.InvalidUser;
import data.ValidUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import steps.LoginUserStep;

public class LoginTest extends BaseTest {
    LoginUserStep loginUserStep = new LoginUserStep();

    @Test
    public void testEnterWithValidCredentials() {
        String actual = loginUserStep.loginWithValidData(ValidUser.EMAIL_VALID, ValidUser.PASSWORD_VALID);
        Assertions.assertEquals(ValidUser.PROFILE_NAME + "!", actual);
    }

    @Test
    public void testEnterWithInvalidEmail() {
        String actual = loginUserStep.loginWithInvalidData(InvalidUser.EMAIL_INVALID, ValidUser.PASSWORD_VALID);
        Assertions.assertEquals(InvalidUser.ERROR_MESSAGE, actual);
    }

    @Test
    public void testEnterWithInvalidPassword() {
        String actual = loginUserStep.loginWithInvalidData(ValidUser.EMAIL_VALID, InvalidUser.PASSWORD_INVALID);
        Assertions.assertEquals(InvalidUser.ERROR_MESSAGE, actual);
    }

    @Test
    public void testEnterWithInvalidCredentials() {
        String actual = loginUserStep.loginWithInvalidData(InvalidUser.EMAIL_INVALID, InvalidUser.PASSWORD_INVALID);
        Assertions.assertEquals(InvalidUser.ERROR_MESSAGE, actual);
    }

    @Test
    public void testEnterWithEmptyEmail() {
        String actual = loginUserStep.loginWithInvalidData("", ValidUser.PASSWORD_VALID);
        Assertions.assertEquals(InvalidUser.ERROR_MESSAGE, actual);
    }

    @Test
    public void testEnterWithEmptyPassword() {
        String actual = loginUserStep.loginWithInvalidData(ValidUser.EMAIL_VALID, "");
        Assertions.assertEquals(InvalidUser.ERROR_MESSAGE, actual);
    }

    @Test
    public void testEnterAndExitFromAccount() {
        boolean actual = loginUserStep.loginAndLogout(ValidUser.EMAIL_VALID, ValidUser.PASSWORD_VALID);
        Assertions.assertFalse(actual);
    }
}
