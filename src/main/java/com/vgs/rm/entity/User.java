package com.vgs.rm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(length = 64, nullable = false)
    @Size(min = 6, max = 60)
    private String password;

    private Boolean active;

    private Timestamp dateLastUpdate;
    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register;

    @ManyToMany
    private List<Role> roles;


    public User(Long id) {
        this.id = id;
    }
}
