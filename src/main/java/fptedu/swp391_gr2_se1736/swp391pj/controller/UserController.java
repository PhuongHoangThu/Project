package fptedu.swp391_gr2_se1736.swp391pj.controller;

import fptedu.swp391_gr2_se1736.swp391pj.model.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import fptedu.swp391_gr2_se1736.swp391pj.dto.UsersDTO;
import fptedu.swp391_gr2_se1736.swp391pj.service.UserService;

@Controller
@RestController
/* Modify your requestMapping */
@RequestMapping(path = "")  // the first path
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession httpSession;

    /*
     * editor: VietNguyen
     * This will send to Login Page
     */
    @RequestMapping("/client/login")
    public ModelAndView showLoginPage() {
        ModelAndView mv = new ModelAndView("client/loginPage");
        return mv;
    }

    /*
     * editor: VietNguyen
     * This will send to Sign-up Page
     */
    @RequestMapping("/client/signup")
    public ModelAndView showSignupPage() {
        ModelAndView mv = new ModelAndView("/client/registerPage");
        return mv;
    }

    /*
     * editor: VietNguyen
     * When user login their username and password in Form from view
     */
    @PostMapping("/client/loginSucces")
    public ModelAndView loginAction(@RequestParam("username") String identify, @RequestParam("password") String password,
                                    HttpSession session) {
        ModelAndView mv = new ModelAndView("/client/loginPage");
        UsersDTO users = userService.getLoginUser(identify, password);
        if (users == null) {
            return mv;
        } else {
            session.setAttribute("user", users);
            session.setMaxInactiveInterval(60 * 60 * 24);
            mv.setViewName("redirect:/client/home");
        }
        return mv;
    }

    @GetMapping("/client/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("user");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/client/home");
        return mv;
    }


    /*
     * editor: VietNguyen
     * When user signup their new account
     */
    @PostMapping("")
    public ModelAndView signupAction() {
        return null;
    }

    @RequestMapping ("/client/profile")
    public ModelAndView showProfilePage() {
        ModelAndView mv = new ModelAndView("/client/profile");
        return mv;
    }

    @PostMapping("/client/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
        return userService.confirmEmail(confirmationToken);
    }
    @PostMapping("/users")
    public String addUser(@RequestBody Users users){
        return userService.addUser(users);
    }

}

    
   


