package ua.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false)Integer a,
                            @RequestParam(value = "b", required = false) Integer b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
       // System.out.println("Hello: " + name + " " + surname);
        Double c = 0.0;
        switch (action) {
            case "multiplication":
                c += a * b;
                break;
            case "addition":
                c += a + b;
                break;
            case "subtraction":
                c += a - b;
                break;
            case "division":
                c += a / (double)b;
                break;
        }
        model.addAttribute("message", "Hello: " + c);


        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePAage(){
        return "first/goodbye";
    }
}
