package com.appdev.app.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name="product")
@Entity
@Data
@NoArgsConstructor
public class Product {
//    @GeneratedValue
    /**   VARCHAR2(20)  */    @Id @Column(name="ID_PRD"            , nullable=false ) private Integer    idPrd             ;
    /**   VARCHAR2(1)   */        @Column(name="NAME"                               ) private String     name           ;
    /**   VARCHAR2(1)   */        @Column(name="PRICE"                              ) private BigDecimal price = BigDecimal.ZERO;

}