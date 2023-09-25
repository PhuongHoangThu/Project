package fptedu.swp391_gr2_se1736.swp391pj.model;

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
public class Courseprocess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer processid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "contentid")
    private Coursecontent coursecontent;

    private Boolean contentstatus;

    // Thêm getters và setters
}
