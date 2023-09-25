package fptedu.swp391_gr2_se1736.swp391pj.service;


import java.util.ArrayList;
import java.util.List;


import fptedu.swp391_gr2_se1736.swp391pj.model.Confirmationtoken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import fptedu.swp391_gr2_se1736.swp391pj.dto.UsersDTO;
import fptedu.swp391_gr2_se1736.swp391pj.model.Users;
import fptedu.swp391_gr2_se1736.swp391pj.respository.UsersRespository;
import fptedu.swp391_gr2_se1736.swp391pj.respository.ConfirmationTokenRepository;



@Service
public class UserService {
    
    @Autowired
    private UsersRespository usersRespository;


    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    EmailService emailService;

    // admin use
    public List<UsersDTO> getUserList(){
        List<Users> uList = usersRespository.getAllUsers();
        List<UsersDTO> udtoList = new ArrayList<UsersDTO>();
        for (Users users : uList) {
            udtoList.add(new UsersDTO(users));
        }
        return udtoList;
    }

    public UsersDTO getLoginUser(String identify, String password){
        List<Users> loginUsers = usersRespository.findAcount(identify, password);
        if(loginUsers.size() == 0){
            return null;
        }
        return new UsersDTO(loginUsers.get(0));
    }


    public ResponseEntity<?> saveUser(Users user) {

        if (usersRespository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        usersRespository.save(user);

        Confirmationtoken confirmationToken = new Confirmationtoken(user);

        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationtoken());
        emailService.sendEmail(mailMessage);

        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationtoken());

        return ResponseEntity.ok("Verify email by the link sent on your email address");
    }


    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        Confirmationtoken token = confirmationTokenRepository.findByConfirmationtoken(confirmationToken);

        if(token != null)
        {
            Users user = usersRespository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setIsenabled(true);
            usersRespository.save(user);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }

    public String addUser(Users users) {

        Users savedUser = usersRespository.save(users);
        return savedUser.getUsername() + " added to database successfully";
    }
}
