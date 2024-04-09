package Shop.Online_Shop.repository;

import Shop.Online_Shop.model.Type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
    boolean existsById(Long id);
}
