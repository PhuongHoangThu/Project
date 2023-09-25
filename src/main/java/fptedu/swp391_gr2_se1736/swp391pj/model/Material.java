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
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialid;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course course;

    private String materiallink;

    private String materialtitle;

    private String materialname;

    private Date materialdob;

    // Thêm getters và setters
}
