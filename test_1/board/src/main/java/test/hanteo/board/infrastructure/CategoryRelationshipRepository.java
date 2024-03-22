package test.hanteo.board.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRelationshipRepository extends JpaRepository<CategoryRelationship, CategoryRelationship> {
}
