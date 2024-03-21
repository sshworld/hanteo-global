package test.hanteo.board.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import test.hanteo.board.request.CategoryCreateRequest;
import test.hanteo.board.request.CategoryUpdateRequest;
import test.hanteo.board.response.CategoryResponse;
import test.hanteo.board.service.CategoryService;

@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories().stream().map(CategoryResponse::new).toList();
    }

    @GetMapping("{id}")
    public CategoryResponse getCategory(@PathVariable Long id) {
        return new CategoryResponse(categoryService.getCategory(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        return new CategoryResponse(categoryService.create(categoryCreateRequest));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        categoryService.update(categoryUpdateRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
