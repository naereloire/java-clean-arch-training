package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import br.com.training.cleanarch.gateway.SubcategoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindSubcategoryById {

    private final SubcategoryGateway subcategoryGateway;

    public List<SubcategoryEntity> findByCategoryId(Long categoryId) {

        return subcategoryGateway.findByParentId(categoryId);
    }
}
