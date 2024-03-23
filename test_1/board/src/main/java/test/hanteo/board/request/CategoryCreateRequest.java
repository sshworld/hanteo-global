package test.hanteo.board.request;

import lombok.Getter;

@Getter
public class CategoryCreateRequest {

    private Long parentCategoryId;

    private String name;
}
