package FileServer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhy on 1/16/17.
 */
@Controller
public class AboutController {
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
