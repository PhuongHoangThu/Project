package fptedu.swp391_gr2_se1736.swp391pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
@RequestMapping(path = "")
public class HomeController {
    @RequestMapping("/client/home")
    public ModelAndView showSignupPage(){
        ModelAndView mv = new ModelAndView("client/index");
        return mv;
    }
}
