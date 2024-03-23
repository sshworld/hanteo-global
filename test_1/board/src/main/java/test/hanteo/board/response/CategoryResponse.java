package test.hanteo.board.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import test.hanteo.board.infrastructure.Category;

@Getter
public class CategoryResponse {

    private final Long id;

    private final String name;

    private final List<ChildCategoryResponse> childCategories;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public CategoryResponse(Category category) {
        id = category.getId();
        name = category.getName();
        childCategories = category.getCategoryRelationships().stream().map(ChildCategoryResponse::new).toList();
        createdAt = category.getCreatedAt();
        updatedAt = category.getUpdatedAt();
    }
}
