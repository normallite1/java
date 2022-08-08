package ua.kostia.social.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.kostia.social.model.User;

@Controller
public class UserControllers {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/accont")
    public String getAccount(Model model, User user){
        model.addAttribute("user", new User ());

        return "";
    }
}
