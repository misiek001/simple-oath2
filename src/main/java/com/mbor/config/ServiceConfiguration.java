package com.mbor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mbor.service", "com.mbor.dao", "com.mbor.security"})
public class ServiceConfiguration {
}
