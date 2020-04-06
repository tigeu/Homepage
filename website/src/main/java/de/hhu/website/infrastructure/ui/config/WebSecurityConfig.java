package de.hhu.website.infrastructure.ui.config;

import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * Standard configuration class needed to inject beans for Spring Boot.
 *
 * @author Leon Geuer
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
class WebSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

  /**
   * TODO: write documentation.
   */
  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) {
    final KeycloakAuthenticationProvider keyclAuthProv = keycloakAuthenticationProvider();
    keyclAuthProv.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
    auth.authenticationProvider(keyclAuthProv);
  }

  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    super.configure(http);
    http.authorizeRequests()
        .antMatchers("/")
        .permitAll();
  }

  /**
   * Declaring this class enables us to use the Spring specific
   * {@link org.springframework.security.access.annotation.Secured} annotation
   * or the JSR-250 Java Standard
   * {@link javax.annotation.security.RolesAllowed} annotation
   * for Role-based authorization.
   */
  @Configuration
  @EnableGlobalMethodSecurity(
      prePostEnabled = true,
      securedEnabled = true,
      jsr250Enabled = true)
  public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
  }

}