package com.amos.tenant.management.domain.repositories;

import com.amos.tenant.management.domain.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant, Long> {
}
