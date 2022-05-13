package com.kms.self203.backend203self.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Task> tasks;
}
