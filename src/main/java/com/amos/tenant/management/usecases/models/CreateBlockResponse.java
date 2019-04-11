package com.amos.tenant.management.usecases.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateBlockResponse {
    Long id;
    String name;
    LocalDate date;



}
