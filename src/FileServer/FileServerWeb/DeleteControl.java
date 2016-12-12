package FileServer.FileServerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by zhy on 12/10/16.
 */
@Controller
public class DeleteControl {
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String DeleteFile(@RequestParam String fileName) throws UnsupportedEncodingException {
        File file = new File(fileName);
        if(file.exists()){
            System.out.println("yes it has");
        }
        if(file.delete())
            return "redirect:/";
        else
            return "error";
    }
}
