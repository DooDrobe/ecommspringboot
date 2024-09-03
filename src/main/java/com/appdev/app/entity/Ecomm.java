package com.appdev.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ecomm {

    @Id
    private String ecommname;
    private Integer ecommPostion;
    private Double ecommRenumeration;
}
