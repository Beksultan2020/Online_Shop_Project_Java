package Shop.Online_Shop.repository;

import Shop.Online_Shop.modеl.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
