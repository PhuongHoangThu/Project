package fptedu.swp391_gr2_se1736.swp391pj.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Enroll {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course course;

    private Date enrolldate;

    private Double checkout;

    private Boolean processstatus;

    // Thêm getters và setters
}
