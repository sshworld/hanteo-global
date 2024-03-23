package test.hanteo.board.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.hanteo.board.request.CategoryCreateRequest;

@Entity
@Getter
@IdClass(CategoryRelationship.class)
@NoArgsConstructor
public class CategoryRelationship implements Serializable {

    @Id
    @JoinColumn(name = "parent_id")
    private Long parentId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Category child;

    public CategoryRelationship(CategoryCreateRequest categoryCreateRequest, Category category) {
        parentId = categoryCreateRequest.getParentCategoryId();
        child = category;
    }
}
