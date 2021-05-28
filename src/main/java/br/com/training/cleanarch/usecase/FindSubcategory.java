package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import br.com.training.cleanarch.gateway.SubcategoryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindSubcategory {

    private SubcategoryGateway subcategoryGateway;

    public FindSubcategory(SubcategoryGateway subcategoryGateway) {
        this.subcategoryGateway = subcategoryGateway;
    }

    public List<SubcategoryEntity> findAllSubCategories() {
        return subcategoryGateway.findAll();
    }
}
