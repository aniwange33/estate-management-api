package com.amos.tenant.management.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estate extends JpaEntityAbstract<Long> {
    private String name;
     @Embedded
    private  Address address;

}

