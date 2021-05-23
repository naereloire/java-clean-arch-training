package br.com.training.cleanarch.gateway;

import br.com.training.cleanarch.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryGateway extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();
}
