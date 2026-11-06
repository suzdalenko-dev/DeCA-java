package com.deca.api.Controllers;

import jakarta.persistence.*;


@Entity 
@Table(name = "user_counter")
public class UserCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = true)
    private Integer value;
}
