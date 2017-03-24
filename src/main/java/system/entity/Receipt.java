package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer receipt_id;

    @Column(name = "data", nullable = false)
    private String data;

    @Column(name = "sum", nullable = false)
    private java.math.BigDecimal sum;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "comment")
    private String comment;

    public Integer getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(Integer receipt_id) {
        this.receipt_id = receipt_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
