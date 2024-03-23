package test.hanteo.board.response;

import java.time.LocalDateTime;
import lombok.Getter;
import test.hanteo.board.infrastructure.Board;

@Getter
public class BoardResponse {

    private final Long id;

    private final CategoryResponse category;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public BoardResponse(Board board) {
        id = board.getId();
        category = new CategoryResponse(board.getCategory());
        createdAt = board.getCreatedAt();
        updatedAt = board.getUpdatedAt();
    }
}
