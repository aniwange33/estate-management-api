package com.amos.tenant.management.infrastructure.persistence.Impl;

import com.amos.tenant.management.domain.models.Role;
import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import com.amos.tenant.management.infrastructure.persistence.entities.models.Name;
import com.amos.tenant.management.infrastructure.persistence.repositories.AccountDbEntityRepo;
import com.amos.tenant.management.infrastructure.persistence.repositories.PrivilegesDbEntityRepo;
import com.amos.tenant.management.infrastructure.security.model.LoginRequestJSON;
import com.amos.tenant.management.infrastructure.security.model.LoginResponseJSON;
import com.amos.tenant.management.infrastructure.web.models.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDbEntityRepo accountDbEntityRepo;
    @Autowired
    PrivilegesDbEntityRepo privilegesDbEntityRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private static Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    @Override
    public AccountDbEntity getAccount(String email) throws UsernameNotFoundException {
       Optional<AccountDbEntity> accountDbEntityOptional=accountDbEntityRepo.findAccountDbEntitiesByEmail(email);
       if(!accountDbEntityOptional.isPresent()){
           throw new UsernameNotFoundException("User not found");
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
            accountDbEntity.setPrivilege(privilegesDbEntityRepo.getOne((long)31));
            accountDbEntity.setPhoneNumber("08101067538");
            accountDbEntity.setPassword(bCryptPasswordEncoder.encode("password"));
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

    public LoginResponseJSON login(LoginRequestJSON user,String urlPath, JsonObject data, Map<String, String> requestParams) {
        logger.info("I am here now");
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            String authorization = getCredentials();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", authorization);
            if (requestParams != null && !requestParams.isEmpty()) {
                for (String key : requestParams.keySet()) {
                    conn.setRequestProperty(key,

                            requestParams.get(key));

                }

            }
            Gson gson = new Gson();
            String input  = "grant_type=" + URLEncoder.encode("password") +
                    "&username=" + URLEncoder.encode(user.getUsername()) +
                    "&password=" + URLEncoder.encode(user.getPassword()) ;
            System.out.println("Request data: " + input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new
                        InputStreamReader((conn.getInputStream())));
                String output;
                while ((output = br.readLine()) != null) {
                    conn.disconnect();
                    logger.info("output in " + output);

                    LoginResponse loginResponse = gson.fromJson(output, LoginResponse.class);
                    LoginResponseJSON response = new LoginResponseJSON(loginResponse);
                    return response;

                }
            }
            if (!(conn.getResponseCode() == HttpURLConnection.HTTP_OK)) {

                BufferedReader br = new BufferedReader(new


                        InputStreamReader((conn.getErrorStream())));
                String output;
                while ((output = br.readLine()) != null) {

                    conn.disconnect();
                    logger.info("output in "+ output);
                    LoginResponseJSON response = new LoginResponseJSON(output);
                    return response;

                }
            }

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;

    }
    private String getCredentials() {
        String plainClientCredentials = "user" + ":" + "userSignKey";
        String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
        String authorization = "Basic " + base64ClientCredentials;
        return authorization;
    }

}
