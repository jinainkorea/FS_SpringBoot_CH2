package com.mysite.sbb_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "<h2>index</h2>";
    }
}
