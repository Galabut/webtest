package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * (дата, клиент, сумма, адрес подачи, адрес назначения)
 * Created by Galabut on 07.02.2015.
 */
@Entity
@Table(name = "order")
public class Order {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_ORD_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long orderId;

    @Column(name = "data_order")
    private Date dateOfOrder;

    @ManyToOne
    private Client client;

    @Column
    private Long sum;

    @Column
    private String departAdress;

    @Column
    private String arrivalAdress;

    public Order(Date dateOfOrder, Client client, Long sum, String departAdress, String arrivalAdress) {
        this.dateOfOrder = dateOfOrder;
        this.client = client;
        this.sum = sum;
        this.departAdress = departAdress;
        this.arrivalAdress = arrivalAdress;
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public String getDepartAdress() {
        return departAdress;
    }

    public void setDepartAdress(String departAdress) {
        this.departAdress = departAdress;
    }

    public String getArrivalAdress() {
        return arrivalAdress;
    }

    public void setArrivalAdress(String arrivalAdress) {
        this.arrivalAdress = arrivalAdress;
    }
}
