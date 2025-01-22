package seminar.proxy;

public class WebsiteAuth implements AuthService {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    @Override
    public boolean login(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
