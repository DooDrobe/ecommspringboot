package com.appdev.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ecomm {

    @Id
    private String ecommname;
    private Integer ecommPostion;
    private Double ecommRenumeration;
}
