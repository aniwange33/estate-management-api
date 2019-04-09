package com.amos.tenant.management.usecases.models;

import lombok.Data;

@Data
public class CreateRoomApartmentResponse {
    long id;
    long name;
    long number;
    long flatId;
}
