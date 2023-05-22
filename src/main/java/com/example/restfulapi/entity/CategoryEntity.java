package com.example.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{
    @Column
    private String code;

    @Column
//    @Column(nullable = false, unique = true, length = 300) //Validate
    private String name;

    @OneToMany(
            mappedBy = "category" //thuoc tinh ben NewEntity
    )
    private List<NewEntity> news = new ArrayList<>();
}
