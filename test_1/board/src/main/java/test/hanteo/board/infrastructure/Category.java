package test.hanteo.board.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import test.hanteo.board.request.CategoryCreateRequest;
import test.hanteo.board.request.CategoryUpdateRequest;

@Entity(name = "category")
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreatedDate
    private LocalDateTime createdAt = now();

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Category(CategoryCreateRequest categoryCreateRequest) {
        name = categoryCreateRequest.getName();
    }

    public void update(CategoryUpdateRequest categoryUpdateRequest) {
        name = categoryUpdateRequest.getName();
    }
}
