package de.hhu.website.infrastructure.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Standard controller class: manages all requests that pertain to the role user.
 *
 * @author Snur Amin / Leon Geuer / Sébastien Croizé-Pourcelet
 */

@Controller
public class HomeController {
  /**
   * LOGGER field required for logging framework slf4j/logback.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  /**
   * All getRequest to "/" are redirected to this method.
   *
   * @return a redirect to the home() method.
   */
  @GetMapping("/")
  @Secured("ROLE_user")
  public String index() {
    return "redirect:home";
  }

  /**
   * All getRequest to "/home" are redirected to this method.
   *
   * @return a view of the home page.
   */
  @GetMapping("/home")
  @Secured("ROLE_user")
  public String home() {
    LOGGER.info("The home page has been loaded by user.");
    return "home";
  }

}
