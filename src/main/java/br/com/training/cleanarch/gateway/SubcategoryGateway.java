package br.com.training.cleanarch.gateway;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryGateway extends JpaRepository <SubcategoryEntity,Long> {
    List<SubcategoryEntity> findAll();
}
