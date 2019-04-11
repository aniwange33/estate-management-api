package com.amos.tenant.management.infrastructure.persistence.entities;

import com.amos.tenant.management.infrastructure.persistence.entities.models.JpaEntityAbstract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="flat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlatDbEntity extends JpaEntityAbstract<Long> {
    private   String name;
    private   String description;
    private   double price;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private BlockDbEntity blockDbEntity;

}
