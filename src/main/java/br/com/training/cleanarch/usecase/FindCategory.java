package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.CategoryEntity;
import br.com.training.cleanarch.gateway.CategoryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindCategory {
    private CategoryGateway categoryGateway;

    public FindCategory(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    //isso é uma regra negócio, para localizar todas as categorias.
    public List <CategoryEntity> findAllCategories (){
        return categoryGateway.findAll();
    }
}
