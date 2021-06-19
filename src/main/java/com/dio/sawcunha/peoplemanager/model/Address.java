package com.dio.sawcunha.peoplemanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PM_Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", nullable = false, foreignKey = @ForeignKey(name = "FK_Person_A"))
    private Person person;

    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "city")
    private String city;
    @Column(name = "addressName")
    private String addressName;
    @Column(name = "state")
    private String state;
    @Column(name = "street")
    private String street;
    @Column(name = "block")
    private String block;
    @Column(name = "country")
    private String country;
    @Column(name = "number")
    private Integer number;
    @Column(name = "complement")
    private String complement;
    @Column(name = "reference")
    private String reference;

}
