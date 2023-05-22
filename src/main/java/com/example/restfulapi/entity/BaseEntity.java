package com.example.restfulapi.entity;

import javax.persistence.*;

@MappedSuperclass //neu khong co khi class entity con ke thua va generation table DB se khong co cac cot nay
public abstract class BaseEntity {
    @Id //not null, primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id; //chi co getter ko co setter

//    @Column(name = "create_by") //set column name
//    private String createdBy; //auto generation column "create_by"
//
//    @Column
//    private Date createBy;


}
