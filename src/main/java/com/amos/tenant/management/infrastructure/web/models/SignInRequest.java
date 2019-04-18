package com.amos.tenant.management.infrastructure.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SignInRequest {

    @JsonIgnore
    private String grant_type;

    private String username;

    private String password;


}
