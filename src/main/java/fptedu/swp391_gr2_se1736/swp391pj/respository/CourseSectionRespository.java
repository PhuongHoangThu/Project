package fptedu.swp391_gr2_se1736.swp391pj.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fptedu.swp391_gr2_se1736.swp391pj.model.Coursesection;

@Repository
public interface CourseSectionRespository extends JpaRepository<Coursesection, Integer>{
    


}
