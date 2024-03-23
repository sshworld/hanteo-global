package test.hanteo.board.service.specification;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import test.hanteo.board.infrastructure.Category;

public class CategorySpecification {

    public static Specification<Category> of(String name) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return criteriaBuilder.equal(root.get("name"), name);
        };
    }
}
