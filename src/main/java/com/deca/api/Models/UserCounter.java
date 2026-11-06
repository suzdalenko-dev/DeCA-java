package com.deca.api.Models;

import jakarta.persistence.*;


@Entity 
@Table(name = "user_counter")
public class UserCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = true)
    private Integer value;

    public UserCounter() {}

    public Long getId() {
        return id;
    }

    public Integer getUserNumber() {
        return value;
    }

    public void setUserNumber(Integer userNumber) {
        this.value = userNumber;
    }
}
