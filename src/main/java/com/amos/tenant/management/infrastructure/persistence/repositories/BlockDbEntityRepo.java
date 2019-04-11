package com.amos.tenant.management.infrastructure.persistence.repositories;

import com.amos.tenant.management.infrastructure.persistence.entities.BlockDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlockDbEntityRepo extends JpaRepository<BlockDbEntity, Long> {
}
