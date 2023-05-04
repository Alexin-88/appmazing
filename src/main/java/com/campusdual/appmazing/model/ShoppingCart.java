package com.campusdual.appmazing.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SHOPPINGCART")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer idproduct;

    @Column
    private Integer idcontact;

    @Column
    private Integer amount;

    @Column
    private Date dateshipped;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public Integer getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(Integer idcontact) {
        this.idcontact = idcontact;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDateshipped() {
        return dateshipped;
    }

    public void setDateshipped(Date dateshipped) {
        this.dateshipped = dateshipped;
    }
}
