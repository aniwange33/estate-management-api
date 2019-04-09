package com.amos.tenant.management.usecases.models;

import lombok.Data;

@Data
public class CreateTenantReponse {
    long id;
    String name;
    String phone;
    Long roomId;

}
