package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Erik on 6/20/16.
 */
@Controller
public class HelloSpringController {

    @RequestMapping(path = "/", method = RequestMethod.GET)

    //public String home(Model model) non query parameters {
    //Person p = new Person("Alice", "Charleston", 30);

    public String home (Model model, HttpSession session, String name, String city, Integer age) { //with query parameters

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

        String username = (String) session.getAttribute("username"); //need to cast
        User user = null;
        if (username != null) {
            user = new User(username);
        }
        model.addAttribute("user", user);

        return "person";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, HttpSession session) {
        session.setAttribute("username", username);
        return "redirect:/";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
