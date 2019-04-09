package com.amos.tenant.management.domain.repositories;

import com.amos.tenant.management.domain.entities.RoomApartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomApartmentRepo extends JpaRepository<RoomApartment, Long> {
}
