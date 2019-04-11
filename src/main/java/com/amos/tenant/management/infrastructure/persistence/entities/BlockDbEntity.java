package com.amos.tenant.management.infrastructure.persistence.entities;


import com.amos.tenant.management.infrastructure.persistence.entities.models.JpaEntityAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "block")
@Getter
@Setter
@NoArgsConstructor
public class BlockDbEntity extends JpaEntityAbstract<Long> {
    private  String name;
    private  Long   numberOfFlat;
    @ManyToOne
    @JoinColumn(name = "estate_id")
    private EstateDbEntity estate;

    public BlockDbEntity(String name, Long numberOfFlat, EstateDbEntity estate) {
        this.name = name;
        this.numberOfFlat = numberOfFlat;
        this.estate = estate;
    }
}
