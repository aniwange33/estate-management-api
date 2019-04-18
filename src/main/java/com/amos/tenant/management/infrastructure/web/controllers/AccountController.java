package com.amos.tenant.management.infrastructure.web.controllers;

import com.amos.tenant.management.infrastructure.persistence.Impl.AccountServiceImpl;
import com.amos.tenant.management.infrastructure.security.model.LoginRequestJSON;
import com.amos.tenant.management.infrastructure.security.model.LoginResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Named;
import javax.validation.Valid;

@RestController("api/v1/account")
@Named
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;
    @PostMapping(value = "/login")
    @ResponseBody
    LoginResponseJSON login(@Valid @RequestBody LoginRequestJSON  loginRequestJSON) {
     return accountService.login(loginRequestJSON,"http://localhost:8080/oauth/token",null,null);
    }
}
