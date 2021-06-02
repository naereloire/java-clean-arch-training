package br.com.training.cleanarch.gateway;

import br.com.training.cleanarch.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductGateway extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT prod FROM ProductEntity prod WHERE subcategory_id = :subcategoryId")
    List<ProductEntity> findByParentId(@Param("subcategoryId") Long subcategoryId);
}
