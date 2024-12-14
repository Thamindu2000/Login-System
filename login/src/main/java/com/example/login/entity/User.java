package com.example.login.entity;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // Generates a constructor with one parameter for each field in the class.
import jakarta.persistence.GeneratedValue; // A shortcut that bundles the features of @ToString, @EqualsAndHashCode, @Getter, @Setter, and @RequiredArgsConstructor.
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Generates a no-arguments constructor.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@DynamicUpdate

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int userId;
    private String username;
    private String name;
    private String address;
    private String role;
    private int contact;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

}
