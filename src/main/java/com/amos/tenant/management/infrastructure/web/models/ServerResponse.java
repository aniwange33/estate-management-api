package com.amos.tenant.management.infrastructure.web.models;

import lombok.Data;

@Data
public class ServerResponse {
    private Object data;
    private  int status;



    @Override
    public String toString() {
        return getData().toString();
    }

}