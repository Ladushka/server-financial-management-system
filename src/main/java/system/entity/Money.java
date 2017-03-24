package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "money")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer money_id;

    @Column(name = "sum", nullable = false)
    private java.math.BigDecimal sum;

    @Column(name = "type", nullable = false)
    private String type;

    public Integer getMoney_id() {
        return money_id;
    }

    public void setMoney_id(Integer money_id) {
        this.money_id = money_id;
    }

    public java.math.BigDecimal getSum() {
        return sum;
    }

    public void setSum(java.math.BigDecimal sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
