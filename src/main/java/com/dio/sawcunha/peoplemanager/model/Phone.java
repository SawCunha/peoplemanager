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
@Table(name = "PM_Phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private Person person;

    @Column(name = "prefix_internattional")
    private Integer prefixInternattional;
    @Column(name = "prefix_national")
    private Integer prefixNational;
    @Column(name = "number")
    private String number;

}
