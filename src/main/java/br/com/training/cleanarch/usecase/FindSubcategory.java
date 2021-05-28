package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class FindSubcategory {

    private SubcategoryGateway subcategoryGateway;

    public FindSubcategory(SubcategoryGateway subcategoryGateway){ this.subcategoryGateway = subcategoryGateway; }

    public List <SubcategoryEntity> findAllSubcategories (){return subcategoryGateway.findAll();}
}
