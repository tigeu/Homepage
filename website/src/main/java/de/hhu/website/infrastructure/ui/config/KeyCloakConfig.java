package de.hhu.website.infrastructure.ui.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Standard configuration class needed to inject beans for Spring Boot.
 *
 * @author Leon Geuer
 */

@Configuration
public class KeyCloakConfig {

  /**
   * TODO: write documentation.
   */
  @Bean
  public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }
}
