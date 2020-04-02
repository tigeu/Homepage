package de.hhu.website.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Warning suppressed because this is a configuration class and does not need constructor
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class KeyCloakConfig {

  @Bean
  public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }
}
