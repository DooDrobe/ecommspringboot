package com.appdev.app.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="prd_category")
@Entity
@Data
@NoArgsConstructor
public class PrdCategory {
    /**   VARCHAR2(20)  */    @Id @Column(name="ID_CTGR"            , nullable=false ) private Integer    idCtgr             ;
    /**   VARCHAR2(1)   */        @Column(name="NAME"                                ) private String     name           ;

}
