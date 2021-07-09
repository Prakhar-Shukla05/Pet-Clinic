package com.prakhar.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="specialites")
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;


}
