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
import test.hanteo.board.request.GenderCreateRequest;
import test.hanteo.board.response.GenderResponse;
import test.hanteo.board.service.GenderService;

@RequestMapping("api/v1/gender")
@RequiredArgsConstructor
@RestController
public class GenderController {

    private final GenderService genderService;

    @GetMapping
    public List<GenderResponse> getAllGender() {
        return genderService.getAllGender().stream().map(GenderResponse::new).toList();
    }

    @GetMapping("{id}")
    public GenderResponse getGender(@PathVariable Long id) {
        return new GenderResponse(genderService.getGender(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenderResponse create(@RequestBody GenderCreateRequest genderCreateRequest) {
        return new GenderResponse(genderService.create(genderCreateRequest));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        genderService.delete(id);
    }
}
