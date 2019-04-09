package com.amos.tenant.management.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tenant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tenant extends JpaEntityAbstract<Long>  {
    private String name;
    private String phone;
    private LocalDate dateOfBirth;
    private String state;
    private String localGov;
    private String gender;
    @OneToOne
    @JoinColumn(name = "room_id")
    private RoomApartment room;
}
