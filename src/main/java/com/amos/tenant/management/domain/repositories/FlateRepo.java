package com.amos.tenant.management.domain.repositories;

import com.amos.tenant.management.domain.entities.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlateRepo extends JpaRepository<Flat, Long> {
}
