package FileServer.FileServerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 12/12/16.
 */
@Controller
public class OpenDic {
    @RequestMapping("/{dic}")
    public String showDic(@RequestParam String dic, Model model) {
        File[] file = new File(dic).listFiles();
        List<File> fileList = new ArrayList<>();
        List<File> dicList = new ArrayList<>();
        for (File f : file ) {
            if(f.isDirectory())
                dicList.add(f);
            else
                fileList.add(f);
        }
        model.addAttribute("fileList", fileList);
        model.addAttribute("dicList", dicList);
        return "index";
    }
}
