package de.hhu.website.infrastructure.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Standard controller class: manages all requests that pertain to the role admin.
 *
 * @author Leon Geuer / Sébastien Croizé-Pourcelet
 */

@Controller
public class AdminController {
  /**
   * LOGGER field required for logging framework slf4j/logback.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

  /**
   * All getRequest on /admin are redirected to this method.
   *
   * @return a view of the admin page.
   */
  @GetMapping("/admin")
  @Secured("ROLE_admin")
  public String admin() {
    LOGGER.info("The admin page has been loaded by admin.");
    LOGGER.error("An error has occurred while loading the admin page by admin.");
    return "admin";
  }

}
