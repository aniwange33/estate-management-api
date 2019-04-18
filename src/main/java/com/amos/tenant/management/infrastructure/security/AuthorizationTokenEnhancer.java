package com.amos.tenant.management.infrastructure.security;


import com.amos.tenant.management.infrastructure.persistence.Impl.AccountService;
import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class AuthorizationTokenEnhancer implements TokenEnhancer {

    @Autowired
    private AccountService accountService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        AccountDbEntity account = accountService.getAccount(user.getUsername());
        final Map<String, Object> additionalInfo = new HashMap<String, Object>();
        additionalInfo.put("user", account);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }

}
