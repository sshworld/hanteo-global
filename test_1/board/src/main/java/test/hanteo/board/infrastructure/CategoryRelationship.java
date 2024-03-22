package test.hanteo.board.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CategoryRelationship {

    @Id
    private Long parentId;

    @Id
    private Long childId;
}
