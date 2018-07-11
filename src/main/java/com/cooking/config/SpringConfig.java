package com.cooking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HibernateConfig.class)
@ComponentScan("com.cooking.dao")
public class SpringConfig {
}
