package steps;

public class LoginUserStep extends BaseStep {

    public String loginWithValidData(String email, String password) {
        return loginPage.openLoginForm()
                .fillEmailInLoginForm(email)
                .fillPasswordInLoginForm(password)
                .clickEnter()
                .findProfileName();
    }

    public String loginWithInvalidData(String email, String password) {
        return loginPage.openLoginForm()
                .fillEmailInLoginForm(email)
                .fillPasswordInLoginForm(password)
                .clickEnter()
                .findMessage();
    }

    public boolean loginAndLogout(String email, String password) {
        return loginPage.openLoginForm()
                .fillEmailInLoginForm(email)
                .fillPasswordInLoginForm(password)
                .clickEnter()
                .closeWindowWithGreetings()
                .logOut()
                .checkAuthorizedUser();
    }
}
