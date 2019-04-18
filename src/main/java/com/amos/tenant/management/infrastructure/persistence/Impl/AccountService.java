package com.amos.tenant.management.infrastructure.persistence.Impl;

import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AccountService {
   AccountDbEntity getAccount (String  email)throws UsernameNotFoundException;
}
