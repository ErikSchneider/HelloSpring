package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Erik on 6/20/16.
 */
@Controller
public class HelloSpringController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    //public String home(Model model) non query parameters {

    public String home (Model model, String name, String city, Integer age) { //with query parameters
        //Person p = new Person("Alice", "Charleston", 30);
        if (name == null) {
            name = "Erik";
        }
        if (city == null) {
            city = "Charleston";
        }
        if (age == null) {
            age = 25;
        }
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "person";
    }
}
