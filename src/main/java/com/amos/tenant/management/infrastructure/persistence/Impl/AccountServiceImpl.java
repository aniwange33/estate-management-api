package com.amos.tenant.management.infrastructure.persistence.Impl;

import com.amos.tenant.management.infrastructure.persistence.entities.models.Name;
import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import com.amos.tenant.management.domain.models.Role;
import com.amos.tenant.management.infrastructure.persistence.repositories.AccountDbEntityRepo;
import com.amos.tenant.management.infrastructure.persistence.repositories.PrivilegesDbEntityRepo;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDbEntityRepo accountDbEntityRepo;
    @Autowired
    PrivilegesDbEntityRepo privilegesDbEntityRepo;


    @Override
    public AccountDbEntity getAccount(String email) throws GenericInputErrorException {
       Optional<AccountDbEntity> accountDbEntityOptional=accountDbEntityRepo.findAccountDbEntitiesByEmail(email);
       if(!accountDbEntityOptional.isPresent()){
           throw new GenericInputErrorException("User not found");
       }
        return accountDbEntityOptional.get();
    }
    @Bean
    private String createSeedUser(){
        Optional<AccountDbEntity> accountDbEntityOptional=accountDbEntityRepo.findAccountDbEntitiesByEmail("terteseamos@gmail.com");
        if(!accountDbEntityOptional.isPresent()){
            AccountDbEntity accountDbEntity=new AccountDbEntity();
            Name name=new Name("Amos","Aniwange","Tertese");
            accountDbEntity.setName(name);
            accountDbEntity.setCreatedDate(LocalDate.now());
            accountDbEntity.setEmail("terteseamos@gmail.com");
            accountDbEntity.setRole(Role.SuperAdmin);
            accountDbEntity.setPrivilege(privilegesDbEntityRepo.getOne(Long.valueOf(31)));
            accountDbEntity.setPassword(Base64.getEncoder().encodeToString("password".getBytes()));
            accountDbEntityRepo.save(accountDbEntity);

            System.err.println("seed user created");
            return "created";
        }
        if(accountDbEntityOptional.isPresent()){
            System.err.println("no need to create seed user");
            return "I will not create again";
        }
        return null;
    }
}
