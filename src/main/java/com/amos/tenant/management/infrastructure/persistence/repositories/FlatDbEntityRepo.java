package com.amos.tenant.management.infrastructure.persistence.repositories;

import com.amos.tenant.management.infrastructure.persistence.entities.FlatDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlatDbEntityRepo extends JpaRepository<FlatDbEntity, Long> {
}
