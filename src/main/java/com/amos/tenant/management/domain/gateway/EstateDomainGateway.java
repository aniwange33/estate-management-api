package com.amos.tenant.management.domain.gateway;

import com.amos.tenant.management.domain.EstateDomain;
import com.amos.tenant.management.domain.models.AvaliableEstateResponseDomain;
import com.amos.tenant.management.domain.models.CreateAnEstateResponseDomain;

import java.util.List;

public interface EstateDomainGateway {
  CreateAnEstateResponseDomain createAnEstate(EstateDomain request);
  List<AvaliableEstateResponseDomain> retrievedAllEstate();
}
