package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Relationship {
    @Id
    private Integer id_friend_1;

    private Integer id_friend_2;

    public Integer getId_friend_1() {
        return id_friend_1;
    }

    public Integer getId_friend_2() {
        return id_friend_2;
    }

    public void setId_friend_1(Integer id_friend_1) {
        this.id_friend_1 = id_friend_1;
    }

    public void setId_friend_2(Integer id_friend_2) {
        this.id_friend_2 = id_friend_2;
    }
}
