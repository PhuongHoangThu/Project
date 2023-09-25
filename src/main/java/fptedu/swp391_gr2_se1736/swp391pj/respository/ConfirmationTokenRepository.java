package fptedu.swp391_gr2_se1736.swp391pj.respository;

import fptedu.swp391_gr2_se1736.swp391pj.model.Confirmationtoken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfirmationTokenRepository extends JpaRepository<Confirmationtoken, Integer> {
    Confirmationtoken findByConfirmationtoken(String confirmationToken);
}
