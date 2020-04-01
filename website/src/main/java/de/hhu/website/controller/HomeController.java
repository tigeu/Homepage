package de.hhu.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  final static Logger logger = LoggerFactory.getLogger(HomeController.class);

  @GetMapping("/")
  @Secured("ROLE_user")
  public String index() {
    return "redirect:home";
  }

  @GetMapping("/home")
  @Secured("ROLE_user")
  public String home() {
    return "home";
  }

}
