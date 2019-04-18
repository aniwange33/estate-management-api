package com.amos.tenant.management.usecases.models;

import com.amos.tenant.management.domain.models.Name;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAccountResponse {
    LocalDate createdDate;
    Long      id;
    Name name;
    String    activationCode;

    public CreateAccountResponse(LocalDate createdDate, Long id, Name name, String activationCode) {
        this.createdDate = createdDate;
        this.id = id;
        this.name = name;
        this.activationCode = activationCode;
    }
}
