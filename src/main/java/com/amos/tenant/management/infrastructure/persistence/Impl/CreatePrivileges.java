package com.amos.tenant.management.infrastructure.persistence.Impl;

import com.amos.tenant.management.infrastructure.persistence.entities.PrivilegeDbEntity;
import com.amos.tenant.management.infrastructure.persistence.repositories.PrivilegesDbEntityRepo;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named
public class CreatePrivileges {
    private final PrivilegesDbEntityRepo privilegesDbEntityRepo;

    @Inject
    public CreatePrivileges(PrivilegesDbEntityRepo privilegesDbEntityRepo) {
        this.privilegesDbEntityRepo = privilegesDbEntityRepo;
    }

    @Bean
    private void createMyPrivileges() {
        List<PrivilegeDbEntity> privilegeDbEntityList = privilegesDbEntityRepo.findAll();
        if(privilegeDbEntityList.size()<3){
            PrivilegeDbEntity createAdminPrivilegeRequest1 = new PrivilegeDbEntity("Admin-privilege");
            createAdminPrivilegeRequest1.setCreatedDate(LocalDate.now());
            PrivilegeDbEntity createUserPrivilegeRequest2 = new PrivilegeDbEntity("User-privilege");
            createUserPrivilegeRequest2.setCreatedDate(LocalDate.now());
            PrivilegeDbEntity createUserPrivilegeRequest3 = new PrivilegeDbEntity("SuperAdmin-privilege");
            createUserPrivilegeRequest3.setCreatedDate(LocalDate.now());
            List<PrivilegeDbEntity> privilegeDbEntities =new ArrayList<>();
            privilegeDbEntities.add(createAdminPrivilegeRequest1);
            privilegeDbEntities.add(createUserPrivilegeRequest2);
            privilegeDbEntities.add(createUserPrivilegeRequest3);
            for(PrivilegeDbEntity privilege:privilegeDbEntities){
                privilegesDbEntityRepo.save(privilege);
            }

        }
    }
}
