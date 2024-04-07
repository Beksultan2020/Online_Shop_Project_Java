package Shop.Online_Shop.repository;

import Shop.Online_Shop.modеl.Product;
import Shop.Online_Shop.modеl.Type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
    boolean existsById(Long id);
}
