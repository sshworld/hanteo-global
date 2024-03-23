package test.hanteo.board.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import test.hanteo.board.request.BoardCreateRequest;
import test.hanteo.board.request.BoardRequest;
import test.hanteo.board.response.BoardResponse;
import test.hanteo.board.service.BoardService;

@RequestMapping("api/v1/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<BoardResponse> getAllBoard(BoardRequest boardRequest) {
        return boardService.getAllBoard(boardRequest).stream().map(BoardResponse::new).toList();
    }

    @GetMapping("{id}")
    public BoardResponse getBoard(@PathVariable Long id) {
        return new BoardResponse(boardService.getBoard(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponse create(@RequestBody BoardCreateRequest boardCreateRequest) {
        return new BoardResponse(boardService.create(boardCreateRequest));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}
