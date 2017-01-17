package FileServer.Controller;

import FileServer.Config.RootPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 1/16/17.
 */
@Controller
public class FileController {
    @RequestMapping("/show/index")
    public String show(Model model, HttpSession session) {
        if(session.getAttribute("name") == null)
            return "redirect:/login";
        String path = RootPath.RootPath+(String)session.getAttribute("name");
        System.out.println(path);
        File[] file = new File(path).listFiles();
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
        model.addAttribute("path",path);
        return "show";
    }

    @RequestMapping(value = "/open")
    public String showDic(@RequestParam String dic, Model model, HttpSession session) {
        if(session.getAttribute("name") == null)
            return "error";
        if(!pathValidation(dic,(String)session.getAttribute("name")))
            return "error";

        File[] file = new File(dic).listFiles();
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
        model.addAttribute("path", dic);
        return "show";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestPart MultipartFile uploadFile, @RequestParam String path) throws IOException {
        uploadFile.transferTo(new File(path+"/"+uploadFile.getOriginalFilename()));
        return "redirect:/open?dic="+path;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String DeleteFile(@RequestParam String fileName) {
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

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(@RequestParam String fileName, HttpServletResponse res, HttpServletRequest req) throws IOException {
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = res.getOutputStream();
        res.setContentType("multipart/form-data");
        res.setHeader("Content-Disposition", "attachment;fileName="+new String(file.getName().getBytes("utf-8"),"iso-8859-1"));
        byte[] stream = new byte[4089];
        int length;
        while ((length = inputStream.read(stream)) > 0) {
            outputStream.write(stream,0,length);
        }
        inputStream.close();
        outputStream.close();
    }
    public boolean pathValidation(String path, String userName) {
        for (String var : path.split("/")) {
            if(var.equals(".."))
                return false;
        }
        String pathBegin = RootPath.RootPath+userName;
        System.out.println(path.substring(0, pathBegin.length()));
        if(!path.substring(0, pathBegin.length()).equals(pathBegin))
            return false;
        return true;
    }
}
