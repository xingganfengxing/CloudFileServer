package FileServer.FileServerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 12/14/16.
 */
@Controller
public class FileServerController {
    private String userName;

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userName, @RequestParam String password) {
        this.userName = userName;
        if(password.equals("zhy331122"))
            return "redirect:/show/index";
        else
            return "redirect:/error";
    }

    @RequestMapping("/show/index")
    public String show(Model model) {

        File[] file = new File("/home/zhy/Data/").listFiles();
        List<File> fileList = new ArrayList<File>();
        List<File> dicList = new ArrayList<File>();
        for (File f : file ) {
            if(f.isDirectory())
                dicList.add(f);
            else
                fileList.add(f);
        }
        model.addAttribute("fileList", fileList);
        model.addAttribute("dicList", dicList);
        model.addAttribute("path","/home/zhy/Data");
        return "show";
    }
}
