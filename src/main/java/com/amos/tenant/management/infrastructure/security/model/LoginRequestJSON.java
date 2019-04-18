package com.amos.tenant.management.infrastructure.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class LoginRequestJSON {
    String username;
    String password;
    @JsonIgnore
    private String grant_type;
    @JsonIgnore
    public LoginRequestJSON(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.grant_type="password";
    }

    public LoginRequestJSON() {
    }
}
