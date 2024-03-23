package test.hanteo.board.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.hanteo.board.infrastructure.Category;
import test.hanteo.board.infrastructure.CategoryRelationship;
import test.hanteo.board.infrastructure.CategoryRelationshipRepository;
import test.hanteo.board.infrastructure.CategoryRepository;
import test.hanteo.board.request.CategoryCreateRequest;
import test.hanteo.board.request.CategoryRequest;
import test.hanteo.board.service.specification.CategorySpecification;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryRelationshipRepository categoryRelationshipRepository;

    public List<Category> getAllCategory(CategoryRequest categoryRequest) {
        return categoryRepository.findAll(CategorySpecification.of(categoryRequest.getName()));
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));
    }

    @Transactional
    public Category create(CategoryCreateRequest categoryCreateRequest) {
        Category category = new Category(categoryCreateRequest);

        categoryRepository.save(category);
        checkHasParentCategory(categoryCreateRequest, category);

        return category;
    }

    private void checkHasParentCategory(CategoryCreateRequest categoryCreateRequest, Category category) {
        if (categoryCreateRequest.getParentCategoryId() != null) {
            categoryRelationshipRepository.save(new CategoryRelationship(categoryCreateRequest, category));
        }
    }

    @Transactional
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));

        categoryRelationshipRepository.deleteAll(category.getCategoryRelationships());
        categoryRepository.delete(category);
    }
}
