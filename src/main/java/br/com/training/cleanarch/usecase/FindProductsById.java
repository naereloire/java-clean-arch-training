package br.com.training.cleanarch.usecase;

import br.com.training.cleanarch.domain.ProductEntity;
import br.com.training.cleanarch.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindProducts {

    final ProductGateway productGateway;

    public List<ProductEntity> findAllProducts() {

        return productGateway.findAll();
    }

}
