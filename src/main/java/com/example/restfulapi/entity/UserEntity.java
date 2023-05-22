package com.example.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String avatar;

    @Column
    private String password;

    @ManyToMany //tao bang trung gian va tao 2 khoa trung gian
    @JoinTable(name = "user_role", //ten table
                joinColumns = @JoinColumn(name = "user_id"), //mapping khoa chinh bang hien tai
                inverseJoinColumns = @JoinColumn(name = "role_id") //mapping khoa chinh bang 2
    )
    private List<RoleEntity> roles = new ArrayList<>();
}
