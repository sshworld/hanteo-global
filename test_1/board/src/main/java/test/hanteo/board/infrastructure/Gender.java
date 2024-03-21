package test.hanteo.board.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import test.hanteo.board.request.GenderCreateRequest;

@Entity(name = "gender")
@Getter
@NoArgsConstructor
public class Gender {

    @Id
    private Long id;

    private String type;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Gender(GenderCreateRequest genderCreateRequest) {
        this.type = genderCreateRequest.getType();
    }
}
