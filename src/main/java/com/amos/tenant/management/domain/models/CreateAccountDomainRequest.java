package com.amos.tenant.management.domain.models;

import lombok.Data;

@Data
public class CreateAccountDomainRequest {
    Name name;
    String email;
    Long phoneNumber;
    Role role;
    Long  privilegeId;

    public CreateAccountDomainRequest(Name name, String email, Long phoneNumber, Role  role, Long  privilegeId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role=role;
        this.privilegeId=privilegeId;
    }
}
