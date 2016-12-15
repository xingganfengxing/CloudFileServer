package FileServer.FileServerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by zhy on 12/12/16.
 */
@Controller
public class DownloadController {
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(@RequestParam String fileName, HttpServletResponse res, HttpServletRequest req) throws IOException {
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = res.getOutputStream();
        res.setContentType("multipart/form-data");
        res.setHeader("Content-Disposition", "attachment;fileName="+new String(file.getName().getBytes("utf-8"),"iso-8859-1"));
        byte[] stream = new byte[2048];
        int length;
        while ((length = inputStream.read(stream)) > 0) {
            outputStream.write(stream,0,length);
        }
        inputStream.close();
        outputStream.close();
    }
}

