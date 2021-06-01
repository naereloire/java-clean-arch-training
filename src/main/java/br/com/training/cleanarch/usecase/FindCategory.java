package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.CategoryEntity;
import br.com.training.cleanarch.gateway.CategoryGateway;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindCategory {
    private CategoryGateway categoryGateway;

    //isso é uma regra negócio, para localizar todas as categorias.
    public List<CategoryEntity> findAllCategories() {
        return categoryGateway.findAll();
    }
}
