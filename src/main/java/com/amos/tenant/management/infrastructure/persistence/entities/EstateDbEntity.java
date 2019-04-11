package com.amos.tenant.management.infrastructure.persistence.entities;

import com.amos.tenant.management.infrastructure.persistence.entities.models.Address;
import com.amos.tenant.management.infrastructure.persistence.entities.models.JpaEntityAbstract;
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
@NoArgsConstructor
public class EstateDbEntity extends JpaEntityAbstract<Long> {
    private String name;
     @Embedded
    private Address address;

    public EstateDbEntity(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

