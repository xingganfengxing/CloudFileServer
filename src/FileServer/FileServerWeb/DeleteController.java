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
public class DeleteController {
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String DeleteFile(@RequestParam String fileName) throws UnsupportedEncodingException {
        File file = new File(fileName);
        String[] backPath = fileName.split("/");
        StringBuilder backPathGet = new StringBuilder();
        backPathGet.append(backPath[0]);
        for(int i = 1; i < backPath.length-1; i++)
            backPathGet.append("/"+backPath[i]);
        if(file.delete())
            return "redirect:/open?dic="+backPathGet;
        else
            return "error";
    }
}
