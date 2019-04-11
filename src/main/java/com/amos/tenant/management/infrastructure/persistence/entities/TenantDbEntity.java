package com.amos.tenant.management.infrastructure.persistence.entities;

import com.amos.tenant.management.infrastructure.persistence.entities.models.JpaEntityAbstract;
import com.amos.tenant.management.infrastructure.persistence.entities.models.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tenant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenantDbEntity extends JpaEntityAbstract<Long> {
    @Embedded
    private Name name;
    private String phone;
    private LocalDate dateOfBirth;
    private String state;
    private String localGov;
    private String gender;
    @OneToOne
    @JoinColumn(name = "flat_id")
    private FlatDbEntity room;
}
