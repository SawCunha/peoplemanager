package com.dio.sawcunha.peoplemanager.model;

import com.dio.sawcunha.peoplemanager.enums.eSex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PM_Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "description")
    private String description;
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private eSex sex;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Address> addresses;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Phone> phones;
}
