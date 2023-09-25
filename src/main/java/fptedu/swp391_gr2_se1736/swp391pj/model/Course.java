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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseid;

    private String coursename;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    private Date createdate;

    private Double courseprice;

    @ManyToOne
    @JoinColumn(name = "courseownerid")
    private Courseowner courseowner;

    private String description;

    private byte[] image;

    private Integer courserating;

    private Integer coursestatus;

    // Thêm getters và setters
}
