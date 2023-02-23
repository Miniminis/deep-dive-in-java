package me.flash.annotationprocessor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    public User() {
    }

    public User(Long id, String name) {
        this.userId = id;
        this.userName = name;
    }

    public User(String name) {
        this.userName = name;
    }
}
