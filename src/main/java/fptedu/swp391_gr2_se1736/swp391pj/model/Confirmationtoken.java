package fptedu.swp391_gr2_se1736.swp391pj.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Confirmationtoken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tokenid;

    private String confirmationtoken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userid")
    private Users user;

    public Confirmationtoken() {}

    public Confirmationtoken(Users user) {
        this.user = user;
        createdDate = new Date();
        confirmationtoken = UUID.randomUUID().toString();
    }



}
