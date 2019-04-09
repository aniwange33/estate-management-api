package com.amos.tenant.management.usecases.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTenantRequest {
    String name;
    String phone;
    LocalDate dateOfBirth;
    String state;
    String localGov;
    String gender;
    Long roomId;
}
