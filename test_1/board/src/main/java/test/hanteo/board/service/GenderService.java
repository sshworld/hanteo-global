package test.hanteo.board.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.hanteo.board.infrastructure.Gender;
import test.hanteo.board.infrastructure.GenderRepository;
import test.hanteo.board.request.GenderCreateRequest;

@Service
@RequiredArgsConstructor
public class GenderService {

    private final GenderRepository genderRepository;

    public List<Gender> getAllGender() {
        return genderRepository.findAll();
    }

    public Gender getGender(Long id) {
        return genderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 아이디를 가진 성별은 존재하지 않습니다."));
    }

    @Transactional
    public Gender create(GenderCreateRequest genderCreateRequest) {
        Gender gender = new Gender(genderCreateRequest);

        return genderRepository.save(gender);
    }

    @Transactional
    public void delete(Long id) {
        Gender gender = genderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 아이디를 가진 성별은 존재하지 않습니다."));

        genderRepository.delete(gender);
    }
}
