package test.hanteo.board.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity(name = "gender_category")
@NoArgsConstructor
public class GenderCategory {

    @Id
    private Long genderId;

    @Id
    private Long categoryId;
}
