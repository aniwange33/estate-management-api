package com.amos.tenant.management.usecases.models;

import lombok.Data;

@Data
public class CreateRoomApartmentRequest {
       String name;
       Long number;
       Long price;
       Long flatId;
}
