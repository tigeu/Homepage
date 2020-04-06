package de.hhu.website.infrastructure.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  @GetMapping("/")
  @Secured("ROLE_user")
  public String index() {
    return "redirect:home";
  }

  @GetMapping("/home")
  @Secured("ROLE_user")
  public String home() {
    LOGGER.info("The home page has been loaded by user.");
    return "home";
  }

}
