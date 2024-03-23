package test.hanteo.board.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.hanteo.board.infrastructure.Board;
import test.hanteo.board.infrastructure.BoardRepository;
import test.hanteo.board.infrastructure.Category;
import test.hanteo.board.infrastructure.CategoryRepository;
import test.hanteo.board.request.BoardCreateRequest;
import test.hanteo.board.request.BoardRequest;
import test.hanteo.board.service.specification.BoardSpecification;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final CategoryRepository categoryRepository;

    public List<Board> getAllBoard(BoardRequest boardRequest) {
        return boardRepository.findAll(BoardSpecification.of(boardRequest.getName()));
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 id를 가진 게시판은 존재하지 않습니다."));
    }

    @Transactional
    public Board create(BoardCreateRequest boardCreateRequest) {
        Category category = categoryRepository.findById(boardCreateRequest.getCategoryId())
                .orElseThrow(() -> new NoSuchElementException("해당 id를 가진 카테고리가 존재하지 않습니다."));
        Board board = new Board(category);

        return boardRepository.save(board);
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 id를 가진 게시판은 존재하지 않습니다."));

        boardRepository.delete(board);
    }
}
