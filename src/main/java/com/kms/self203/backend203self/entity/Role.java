package com.kms.self203.backend203self.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Account> account;

    public Role(Integer id, ERole role) {
        this.id = id;
        this.role = role;
    }
}
