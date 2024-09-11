package com.mysite.sbb_t1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainContainer {
  @GetMapping("/")
  public String root() {
    return "redirect:/article/list";
  }
}
