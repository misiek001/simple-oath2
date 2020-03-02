package com.mbor.web.config;

import com.mbor.config.PersistenceConfiguration;
import com.mbor.config.ServiceConfiguration;
import com.mbor.security.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ServiceConfiguration.class, PersistenceConfiguration.class, SecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
