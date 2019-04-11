package com.amos.tenant.management.domain;

import com.amos.tenant.management.domain.models.TenantName;
import lombok.Data;

@Data
public class TenantDomain {
    TenantName name;
    String phoneNumber;
    //open to extension but close for modification

    public TenantDomain(TenantName name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
