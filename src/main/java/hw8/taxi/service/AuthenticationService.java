package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * Created by Galabut on 16.01.2015.
 */

public interface AuthenticationService {

    boolean authenticate(String login, String pass) throws AuthenticationException;
    boolean passwordTermsOfValidation(String login);
    void newPassword(String login, String oldPassword, String newPassword);
    public Operator findOperator(String login);
}
