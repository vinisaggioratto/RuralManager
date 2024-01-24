package com.vgs.rm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "main_account")
public class MainAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fantasyName;

    @Column(length = 18, nullable = false, unique = true)
    private String cpf_cnpj;

    @Column(length = 4, nullable = false)
    private Integer numberAuthorizedUsers; //default 1

    @Column(length = 4, nullable = false)
    private Integer numberAuthorizedActivity; //default 1

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register;

    public MainAccount(Long id) {
        this.id = id;
    }
}
