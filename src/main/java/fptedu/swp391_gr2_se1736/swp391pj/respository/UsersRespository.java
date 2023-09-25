package fptedu.swp391_gr2_se1736.swp391pj.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import fptedu.swp391_gr2_se1736.swp391pj.model.Users;


@Repository
public interface UsersRespository extends JpaRepository<Users, Integer>{

    @Query("Select u from Users u")
    List<Users> getAllUsers();

    List<Users> findByUsernameAndPassword(String identify, String password);

    @Query("Select u from Users u where (u.username = ?1 or u.email = ?1) and u.password = ?2")
    List<Users> findAcount(String identify, String password);

    Users findByEmailIgnoreCase(String emailId);

    Boolean existsByEmail(String email);
}
