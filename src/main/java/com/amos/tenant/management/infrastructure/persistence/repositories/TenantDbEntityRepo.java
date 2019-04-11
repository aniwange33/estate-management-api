package com.amos.tenant.management.infrastructure.persistence.repositories;

import com.amos.tenant.management.infrastructure.persistence.entities.TenantDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantDbEntityRepo extends JpaRepository<TenantDbEntity, Long> {
}
