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
@Table(name = "PM_People")
public class People {

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
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "description")
    private String description;
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private eSex sex;
    @OneToMany(mappedBy = "people")
    List<Address> addresses;
    @OneToMany(mappedBy = "people")
    List<Phone> phones;
}
