package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import br.com.training.cleanarch.gateway.SubcategoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindSubcategory {

    private final SubcategoryGateway subcategoryGateway;

    public List<SubcategoryEntity> findAllSubCategories() {

        return subcategoryGateway.findAll();
    }
}
