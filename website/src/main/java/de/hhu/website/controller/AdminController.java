package de.hhu.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// Warning suppressed because controller classes don't need constructors
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class AdminController {
  public final static Logger logger = LoggerFactory.getLogger(AdminController.class);

  @GetMapping("/admin")
  @Secured("ROLE_admin")
  public String admin() {
    logger.info("The admin page has been loaded by admin.");
    logger.error("An error has occurred while loading the admin page by admin.");
    return "admin";
  }

}
