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
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizid;

    @ManyToOne
    @JoinColumn(name = "coursesectionid")
    private Coursesection coursesection;

    private String quizcontent;

    private Date quizdob;

    // Thêm getters và setters
}
