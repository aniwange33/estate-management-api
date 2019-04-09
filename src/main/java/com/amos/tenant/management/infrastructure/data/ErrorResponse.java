package com.amos.tenant.management.infrastructure.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    LocalDateTime localDateTime;
    String message;

}
