package br.com.training.cleanarch.gateway;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubcategoryGateway extends JpaRepository<SubcategoryEntity, Long> {

    @Query("SELECT sb FROM SubcategoryEntity sb WHERE category_id = :categoryId")
    List<SubcategoryEntity> findByParentId(@Param("categoryId") Long categoryId);
}
