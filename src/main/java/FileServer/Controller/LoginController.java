package FileServer.Controller;

import FileServer.Model.User;
import FileServer.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by zhy on 12/14/16.
 */
@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@ModelAttribute User user, Model model, HttpSession session) {
        User toValidate = userService.findUserByName(user.getName());
        if(toValidate == null) {
            model.addAttribute("errors", "user is not exist!");
            return "login";
        }
        if( !toValidate.getPassword().equals(user.getPassword())) {
            model.addAttribute("errors", "password is not true!");
            return "login";
        }
        session.setAttribute("name", user.getName());
        return "redirect:/show/index";
    }
}
