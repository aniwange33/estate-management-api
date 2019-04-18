package com.amos.tenant.management.infrastructure.persistence.repositories;

import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountDbEntityRepo extends JpaRepository<AccountDbEntity, Long> {
    Optional<AccountDbEntity> findAccountDbEntitiesByEmail(String email);
}
