package seminar.proxy;

public class AuthProxy implements AuthService {
    private final AuthService auth;
    private int numberOfFailedAttempts = 0;

    public AuthProxy(AuthService auth) {
        this.auth = auth;
    }

    @Override
    public boolean login(String username, String password) {
        if (numberOfFailedAttempts > 2) {
            return false;
        } else {
            boolean isLoginSuccessful = auth.login(username, password);
            if (isLoginSuccessful) {
                numberOfFailedAttempts = 0;
            } else {
                numberOfFailedAttempts++;
            }
            return isLoginSuccessful;
        }
    }
}
