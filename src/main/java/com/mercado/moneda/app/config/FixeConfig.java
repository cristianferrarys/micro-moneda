package com.mercado.moneda.app.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("service-fixe")
public class FixeConfig {
  private String url;
  private String access_key;
}
