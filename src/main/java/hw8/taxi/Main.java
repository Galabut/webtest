package hw8.taxi;

import hw8.taxi.service.AuthenticationServiceImpl;

/**
 * Created by Galabut on 28.01.2015.
 */
public class Main {
    public static void main(String[] args) {
        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
        authenticationService.createUsers();
    }
}
