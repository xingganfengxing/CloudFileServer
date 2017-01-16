package FileServer.Controller;

import FileServer.Config.RootPath;
import FileServer.Model.User;
import FileServer.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * Created by zhy on 1/16/17.
 */
@Controller
public class SignController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    public String Sign(@ModelAttribute User user, Model model, HttpSession session) {
        if(user.getName().equals("")) {
            model.addAttribute("error","name is not null");
            return "redirect:/";
        }
        if(user.getPassword().equals("")) {
            model.addAttribute("error", "password is not null");
            return "redirect:/";
        }
        for(User var : userService.findAll()) {
            if(var.getName().equals(user.getName())) {
                model.addAttribute("error", "name has been taken!");
                return "redirect:/";
            }
        }
        userService.save(user);
        File file = new File(RootPath.RootPath+user.getName());
        file.mkdir();
        session.setAttribute("name", user.getName());

        return "redirect:/show/index";
    }
}
