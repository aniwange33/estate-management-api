package com.amos.tenant.management.infrastructure.persistence.entities;

import com.amos.tenant.management.infrastructure.persistence.entities.models.JpaEntityAbstract;
import com.amos.tenant.management.infrastructure.persistence.entities.models.Name;
import com.amos.tenant.management.domain.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class AccountDbEntity extends JpaEntityAbstract<Long> {
    @Embedded
    private Name name;
    private String email;
    private Role role;
    private String password;
    @Column(name = "phone_number")
    private Long     phonenumber;
    private String    verificationcode;
    private LocalDate modifieddate;
    @ManyToOne
    @JoinColumn(name = "privilege_id")
    PrivilegeDbEntity  privilege;
    public AccountDbEntity(Name name,  Role role,String email, String password, Long phonenumber,  PrivilegeDbEntity privilege) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.phonenumber = phonenumber;
        this.privilege = privilege;
    }
}
