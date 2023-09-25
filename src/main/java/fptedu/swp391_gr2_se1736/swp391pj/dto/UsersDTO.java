package fptedu.swp391_gr2_se1736.swp391pj.dto;

import java.util.Date;

import fptedu.swp391_gr2_se1736.swp391pj.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UsersDTO
 */
@Getter
@Setter
@NoArgsConstructor
public class UsersDTO {
    private Integer userId;
    private String fullName;
    private String email;
    private Boolean gender;
    private Date dob;
    private String address;
    private String userName;
    private Integer role;
    private Date registerDob;
    private String avatar;


    public UsersDTO(Users u){
        this.userId = u.getUserid();
        this.fullName = u.getFullname();
        this.email = u.getEmail();
        this.dob = u.getDob();
        this.address = u.getAddress();
        this.userName = u.getUsername();
        this.role = u.getRole();
        this.registerDob = u.getRegisterdob();
        this.gender = u.getGender();
        this.avatar = u.getAvatar();
    }

    @Override
    public String toString() {
        return "UsersDTO [fullName=" + fullName + ", email=" + email + ", gender=" + gender + ", dob=" + dob
                + ", address=" + address + ", userName=" + userName + ", role=" + role + ", registerDob=" + registerDob
                + "]";
    }

    
}