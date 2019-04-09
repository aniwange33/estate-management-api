package com.amos.tenant.management.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="room_apartment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomApartment  extends  JpaEntityAbstract<Long> {
    private   String name;
    private   Long number;
    private   Long price;
    @ManyToOne
    @JoinColumn(name = "flat_id")
    private  Flat flat;

}
