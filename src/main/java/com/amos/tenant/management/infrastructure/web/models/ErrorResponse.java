package com.amos.tenant.management.infrastructure.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    LocalDateTime localDateTime;
    String message;

}
