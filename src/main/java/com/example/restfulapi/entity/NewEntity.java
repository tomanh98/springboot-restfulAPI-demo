package com.example.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "new")
public class NewEntity extends BaseEntity{
    @Column
    private String title;

    @Column
    private String thumbnail;

    @Column
    private String shortDescription;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn (name = "category_id") //ten khoa phu lien ket vs bang category
    private CategoryEntity category;
}
