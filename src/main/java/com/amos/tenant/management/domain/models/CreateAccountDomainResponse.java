package com.amos.tenant.management.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAccountDomainResponse {
    LocalDate createdDate;
    Long     id;
    Name      name;
    String    activationCode;
    public CreateAccountDomainResponse(LocalDate createdDate, Long id, Name name, String activationCode) {
        this.createdDate = createdDate;
        this.id = id;
        this.name = name;
        this.activationCode = activationCode;
    }
}
