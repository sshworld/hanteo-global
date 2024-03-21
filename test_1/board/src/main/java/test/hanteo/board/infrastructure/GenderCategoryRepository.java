package test.hanteo.board.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderCategoryRepository extends JpaRepository<GenderCategory, GenderCategory> {
    Optional<GenderCategory> findByCategoryId(Long id);
}
