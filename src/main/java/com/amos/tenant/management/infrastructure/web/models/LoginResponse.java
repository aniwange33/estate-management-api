package com.amos.tenant.management.infrastructure.web.models;

import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import lombok.Data;

@Data
public class LoginResponse {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String scope;
    private AccountDbEntity user;
}
