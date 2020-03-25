package de.hhu.website.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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
