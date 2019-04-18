package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.models.CreateAccountDomainRequest;
import com.amos.tenant.management.domain.models.Name;
import com.amos.tenant.management.domain.models.Role;
import lombok.Data;

@Data
public class CreateAccountRequest {
    Name name;
    String email;
    Long phoneNumber;
    Role role;
    Long privilegeId;

    public CreateAccountRequest(Name name, String email, Long phoneNumber, Role role, Long privilegeId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.privilegeId = privilegeId;
    }

    public CreateAccountDomainRequest getCreatedAccountRequest(){
        return new CreateAccountDomainRequest(this.name,this.email,this.phoneNumber, this.role,this.privilegeId);
    }
}
