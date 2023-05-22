package com.example.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity{
    @Column
    private String code;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles") //mappedBy = ten thang list dinh nghia ben User
    private List<UserEntity> users = new ArrayList<>();
}
