package com.amos.tenant.management.domain.entities;


import com.amos.tenant.management.domain.enumeration.FlatEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flat  extends JpaEntityAbstract<Long>  {
    private  String name;
    private  FlatEnum  number;
    @ManyToOne
    @JoinColumn(name = "estate_id")
    private Estate estate;
}
