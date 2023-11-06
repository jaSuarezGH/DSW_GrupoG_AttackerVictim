package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
public class UserType {

    public UserType() {
    }

    public UserType(long id) {
        _id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "name", nullable = false)
    private String _name;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
