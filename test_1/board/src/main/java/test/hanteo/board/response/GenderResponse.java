package test.hanteo.board.response;

import java.time.LocalDateTime;
import lombok.Getter;
import test.hanteo.board.infrastructure.Gender;

@Getter
public class GenderResponse {

    private final Long id;

    private final String type;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public GenderResponse(Gender gender) {
        id = gender.getId();
        type = gender.getType();
        createdAt = gender.getCreatedAt();
        updatedAt = gender.getUpdatedAt();
    }
}
