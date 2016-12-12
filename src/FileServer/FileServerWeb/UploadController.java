package FileServer.FileServerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhy on 12/12/16.
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestPart MultipartFile uploadFile) throws IOException {
        uploadFile.transferTo(new File("/home/zhy/Data/"+uploadFile.getOriginalFilename()));
        return "redirect:/";
    }
}
