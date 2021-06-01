package br.com.training.cleanarch.gateway;

import br.com.training.cleanarch.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductGateway extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();
}
