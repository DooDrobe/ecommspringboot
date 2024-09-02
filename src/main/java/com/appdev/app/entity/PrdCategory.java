package com.appdev.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="prd_category")
@Entity
@Data
@NoArgsConstructor
public class PrdCategory {
    /**   VARCHAR2(20)  */    @Id @Column(name="ID_CTGR"            , nullable=false ) private String     idCtgr             ;
    /**   VARCHAR2(1)   */        @Column(name="NAME"                                ) private String     name           ;

}
