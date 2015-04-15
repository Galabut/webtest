package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Galabut on 22.01.2015.
 * Пользователь вводит:
 * - логин (должен быть не менее 4 символов, не должен содержать пробелы)
 * - идентификационный номер (10 цифр, без букв и других знаков)
 * - пароль (должен быть не менее 8 символов,
 * включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
 * - подтверждение пароля
 * - пользователь с таким логином должен быть уникальным
 */
@Component("AuthorizationServiceImpl")
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private OperatorDao dao;

    public Operator findOperator(String login) {
        List<Operator> operators = dao.findAll();
        Operator operatorFound = null;
        for (int i = 0; i < operators.size(); i++) {
            if (login.equals(operators.get(i).getLogin())) {
                operatorFound = operators.get(i);
                break;
            }
        }
        return operatorFound;
    }


    @Override
    public boolean register(String login, String id, String pass) throws AuthorizationException {
        if (findOperator(login)!=null && (login.equals(findOperator(login).getLogin()))) {
            throw new AuthorizationException("Such LOGIN already exists!");
        }
        if (login.length() < 4) {
            throw new AuthorizationException("Your Login is too short! Your login must contain at least 4 symbols!");
        }
        if (login.contains(" ")) {
            throw new AuthorizationException("Your Login must not contain spaces!");
        }
        if (id.length() != 10) {
            {
                throw new AuthorizationException("Your ID is either short or long! Your ID must contain exactly 10 symbols!");
            }
        }
        Long idInt = 0L;
        try {
            idInt = Long.parseLong(id);
        } catch (Exception e) {
            String message = "You ID contains not only digits, but some other symbols!";
            System.out.println(message);
            throw new AuthorizationException(message);
        }
        if (pass.length() < 8) {
            throw new AuthorizationException("Your PASSWORD is too short! IT contain at least 8 symbols!");
        }
        String passToLowerCase = pass.toLowerCase();
        if (pass.equals(passToLowerCase)) {
            throw new AuthorizationException("Your PASSWORD contains only LowerCase symbols!");
        }
        String passToUpperCase = pass.toUpperCase();
        if (pass.equals(passToUpperCase)) {
            throw new AuthorizationException("Your PASSWORD contains only UpperCase symbols!");
        }
        int counterTruth = 0;
        for (Integer i = 0; i <= 9; i++) {
            String ii = String.valueOf(i);
            boolean containsDigit = pass.contains(ii);
            if (containsDigit) {
                counterTruth++;
            }
        }
        if (counterTruth == 0) {
            throw new AuthorizationException("Your PASSWORD contains only letters!");
        }
        if (counterTruth == pass.length()) {
            throw new AuthorizationException("Your PASSWORD contains only digits!");
        }
        //if (AuthenticationServiceImpl.usersMap.containsKey(login)) {
        Operator operatorToAdd = new Operator(login, pass, idInt, new Date());
        //AuthenticationServiceImpl.usersMap.put(operatorToAdd.getLogin(), operatorToAdd);
        dao.create(operatorToAdd);
        return true;
    }
}
