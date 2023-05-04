package com.campusdual.appmazing.model.dto;

import java.util.Date;

public class ShoppingCartDto {

    private Integer id;

    private Integer idproduct;

    private Integer idcontact;

    private Integer amount;

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
