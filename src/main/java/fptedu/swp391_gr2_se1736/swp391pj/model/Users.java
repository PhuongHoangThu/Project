package fptedu.swp391_gr2_se1736.swp391pj.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
//@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    private String fullname;

    private String email;

    private Boolean gender;

    private Date dob;

    private String address;

    private String username;

    private String password;

    private Integer role;

    private Date registerdob;

    private String avatar;

    private Boolean isenabled;

}
