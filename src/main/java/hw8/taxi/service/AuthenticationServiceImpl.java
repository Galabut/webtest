package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.dao.OperatorDaoImpl;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Galabut on 17.01.2015.
 */
@Component("AuthenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService {

    // public static HashMap<String, Operator> usersMap = new HashMap<>();
    private final static Long VALIDITYOFPASSWORD = 360 * 24 * 60 * 60 * 1000L;

    @Autowired
    private OperatorDao dao;

    public void createUsers() {
        Operator operator1 = new Operator("Julia", "123", new Date(1390147200000L));
        Operator operator2 = new Operator("Sergey", "qwer", new Date());
        Operator operator3 = new Operator("Mary", "000", new Date(1421760243784L));
        dao.create(operator1);
        dao.create(operator2);
        dao.create(operator3);

        //usersMap.put(operator1.getLogin(), operator1);
        //usersMap.put(operator2.getLogin(), operator2);
        //usersMap.put(operator3.getLogin(), operator3);

    }

    @Override
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
    public boolean authenticate(String login, String pass) throws AuthenticationException {
       // createUsers();
        System.out.println(findOperator(login));
        if (findOperator(login) == null) throw new AuthenticationException("No such operator. The login is incorrect!");
        // if (usersMap.containsKey(login) && usersMap.get(login).getPassword().equals(pass)) {
        if (login.equals(findOperator(login).getLogin()) && pass.equals(findOperator(login).getPassword())) {
            return true;
        }
        //} else if (usersMap.containsKey(login) != true)
        // } else if (usersMap.get(login).getAmountOfTrialsLeft()== 0)
        else if (findOperator(login).getAmountOfTrialsLeft() == 0) {
            throw new AuthenticationException("You have used all your trials! You are blocked now!");
        } else {
            //Operator operatorCurrent = usersMap.get(login);
            Operator operatorCurrent = findOperator(login);
            operatorCurrent.setAmountOfTrialsLeft(operatorCurrent.getAmountOfTrialsLeft() - 1);
            dao.update(operatorCurrent);
            //usersMap.put(operatorCurrent.getLogin(), operatorCurrent);
            throw new AuthenticationException("The password is incorrect! Be careful, you have limited amount of attempts left - " + operatorCurrent.getAmountOfTrialsLeft());
        }
    }

    @Override
    public boolean passwordTermsOfValidation(String login) {
        Date date = new Date();
        Date userDateOfLogin = findOperator(login).getDataOfLogin();
        System.out.println(date + "today");
        System.out.println(userDateOfLogin + "dayOfLogin");
        if (login.equals(findOperator(login).getLogin()) && ((date.getTime() - userDateOfLogin.getTime()) >= VALIDITYOFPASSWORD)) {
            return false;
        }
        return true;
    }

    @Override
    public void newPassword(String login, String oldPassword, String newPassword) {
        //if (usersMap.containsKey(login) && usersMap.get(login).getPassword().equals(oldPassword)) {
        if (login.equals(findOperator(login).getLogin()) && oldPassword.equals(findOperator(login).getPassword())) {
            findOperator(login).setPassword(newPassword);
            findOperator(login).setDataOfLogin(new Date());
            dao.update(findOperator(login));
        }
    }
}
