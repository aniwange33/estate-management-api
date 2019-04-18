package com.amos.tenant.management.infrastructure.persistence.Impl;

import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;

public interface AccountService {
   AccountDbEntity getAccount (String  email) throws GenericInputErrorException;
}
