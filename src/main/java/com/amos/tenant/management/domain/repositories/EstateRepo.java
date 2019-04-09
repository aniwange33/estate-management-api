package com.amos.tenant.management.domain.repositories;

import com.amos.tenant.management.domain.entities.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepo extends JpaRepository<Estate, Long> {
    Estate findById(long id);
}
