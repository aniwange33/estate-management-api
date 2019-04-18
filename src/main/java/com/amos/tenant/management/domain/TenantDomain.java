package com.amos.tenant.management.domain;

import com.amos.tenant.management.domain.models.Name;
import lombok.Data;

@Data
public class TenantDomain {
    Name name;
    String phoneNumber;
    //open to extension but close for modification

    public TenantDomain(Name name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
