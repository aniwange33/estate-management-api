package com.amos.tenant.management.infrastructure.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponseJSON {
    Object data;
    public LoginResponseJSON(Object data) {
        this.data = data;
    }


}
