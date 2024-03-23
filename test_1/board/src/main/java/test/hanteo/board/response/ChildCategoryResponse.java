package test.hanteo.board.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import test.hanteo.board.infrastructure.Category;
import test.hanteo.board.infrastructure.CategoryRelationship;

@Getter
public class ChildCategoryResponse {

    private final Long id;

    private final String name;

    private final List<ChildCategoryResponse> childCategories;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public ChildCategoryResponse(CategoryRelationship categoryRelationship) {
        Category category = categoryRelationship.getChild();

        id = category.getId();
        name = category.getName();
        childCategories = category.getCategoryRelationships().stream().map(ChildCategoryResponse::new).toList();
        createdAt = category.getCreatedAt();
        updatedAt = category.getUpdatedAt();
    }
}
