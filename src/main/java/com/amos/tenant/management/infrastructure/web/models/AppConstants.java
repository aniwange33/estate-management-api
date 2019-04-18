package com.amos.tenant.management.infrastructure.web.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {
    @Value("${app.url}")
    public String APP_URL;

    @Value("${app.name}")
    public String APP_NAME;


    @Value("${app.description}")
    public String APP_DESCRIPTION;

    @Value("${app.api-license-url}")
    public String APP_LICENSE_URL;

    @Value("${app.api-author}")
    public String APP_AUTHOR;

    @Value("${app.api-web-url}")
    public String APP_WEB_URL;

    @Value("${app.api-email}")
    public String APP_EMAIL;

    @Value("${app.api-version}")
    public String APP_VERSION;

    @Value("${app.admin-email}")
    public String APP_ADMIN_EMAIL;

    @Value("${app.admin-password}")
    public String APP_ADMIN_PASSWORD;

    @Value("${app.default-admin-name}")
    public String APP_DEFAULT_ADMIN_NAME;

    @Value("${app.default-admin-phone}")
    public String APP_DEFAULT_ADMIN_PHONE;

    @Value("${app.default-admin-address}")
    public String APP_DEFAULT_ADMIN_ADDRESS;

    private AppConstants() {
    }

}
