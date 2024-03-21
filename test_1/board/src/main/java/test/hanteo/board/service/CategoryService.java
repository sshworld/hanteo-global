package test.hanteo.board.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.hanteo.board.infrastructure.Category;
import test.hanteo.board.infrastructure.CategoryRepository;
import test.hanteo.board.infrastructure.GenderCategory;
import test.hanteo.board.infrastructure.GenderCategoryRepository;
import test.hanteo.board.request.CategoryCreateRequest;
import test.hanteo.board.request.CategoryUpdateRequest;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final GenderCategoryRepository genderCategoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));
    }

    @Transactional
    public Category create(CategoryCreateRequest categoryCreateRequest) {
        Category category = new Category(categoryCreateRequest);

        categoryRepository.save(category);
        genderCategoryRepository.save(new GenderCategory(categoryCreateRequest.getGenderId(), category.getId()));

        return category;
    }

    @Transactional
    public void update(CategoryUpdateRequest categoryUpdateRequest) {
        Category category = categoryRepository.findById(categoryUpdateRequest.getId())
                .orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));

        category.update(categoryUpdateRequest);
    }

    @Transactional
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));
        GenderCategory genderCategory = genderCategoryRepository.findByCategoryId(category.getId())
                .orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));

        genderCategoryRepository.delete(genderCategory);
        categoryRepository.delete(category);
    }
}
