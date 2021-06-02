package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.ProductEntity;
import br.com.training.cleanarch.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindProductsById {

    final ProductGateway productGateway;

    public List<ProductEntity> findBySubcategoryId(Long subcategoryId) {

        return productGateway.findByParentId(subcategoryId);
    }

}
