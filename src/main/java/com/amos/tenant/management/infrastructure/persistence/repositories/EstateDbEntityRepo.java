package com.amos.tenant.management.infrastructure.persistence.repositories;

import com.amos.tenant.management.infrastructure.persistence.entities.EstateDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateDbEntityRepo extends JpaRepository<EstateDbEntity, Long> {
    EstateDbEntity findById(long id);
}
