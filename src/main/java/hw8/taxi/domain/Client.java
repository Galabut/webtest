package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Galabut on 23.01.2015.
 * Учёт клиентов службы такси.
 Функции:
 - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 - вывести всех клиентов порциями по 10 человек
 - вывести всех клиентов наездивших на сумму больше указанной
 - вывести всех клиентов, делавших заказы за последний месяц

 webapp
 index.jsp
 dashboard.jsp - страница со списком функций (доступна после аутентификации)
 registerClient.jsp - форма создания клиента
 clients.jsp - список клиентов
 */

@Entity
@Table(name="Clients")
public class Client {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CL_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private Integer sum;
    @Column
    private Date lastOrderDate;

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public Client() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;

        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }
}
