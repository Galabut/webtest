package hw8.taxi.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Galabut on 21.01.2015.
 */

@Entity
@Table(name = "operator")
public class Operator {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_OP_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long operatorId;

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private Date dataOfLogin;
    @Column
    private Integer amountOfTrialsLeft = 3;

    public Operator(String login, String password, Date dataOfLogin) {
        this.login = login;
        this.password = password;
        this.dataOfLogin = dataOfLogin;
    }

    public Operator(String login, String password, Long operatorId, Date dataOfLogin) {
        this.login = login;
        this.password = password;
        this.operatorId = operatorId;
        this.dataOfLogin = dataOfLogin;
    }

    public Integer getAmountOfTrialsLeft() {
        return amountOfTrialsLeft;
    }

    public void setAmountOfTrialsLeft(Integer amountOfTrialsLeft) {
        this.amountOfTrialsLeft = amountOfTrialsLeft;
    }

    public Operator() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataOfLogin() {
        return dataOfLogin;
    }

    public void setDataOfLogin(Date dataOfLogin) {
        this.dataOfLogin = dataOfLogin;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
