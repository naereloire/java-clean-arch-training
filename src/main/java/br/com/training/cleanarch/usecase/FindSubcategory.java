package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import br.com.training.cleanarch.gateway.SubcategoryGateway;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindSubcategory {
    private SubcategoryGateway subcategoryGateway;
    public List<SubcategoryEntity> findAllSubCategories() {
        return subcategoryGateway.findAll();
    }
}
