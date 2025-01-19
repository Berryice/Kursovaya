package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GController {

    @RequestMapping(value = "/cabinet")
    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    @RequestMapping(value = "/doctor")
    public String doctor() {
        return "doctor";
    }
    @RequestMapping(value = "/user")
    public String user() {
        return "user";
    }
    @RequestMapping(value = "/visitResults")
    public String visit_results() {
        return "visres";
    }
    @RequestMapping(value = "/visit")
    public String visits() {
        return "visits";
    }
    @RequestMapping(value = "/good")
    public String hurhur() {
        return "good";
    }
}
