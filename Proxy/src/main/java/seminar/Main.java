package seminar;

import seminar.proxy.AuthProxy;
import seminar.proxy.AuthService;
import seminar.proxy.WebsiteAuth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authenticationService =
                new AuthProxy(new WebsiteAuth());
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("user: ");
            String username = scanner.nextLine();
            System.out.print("password: ");
            String password = scanner.nextLine();
            System.out.println(
                    authenticationService.login(username, password));
        }
    }
}
