package br.com.training.cleanarch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subcategories", schema = "recommendation", catalog = "recommendation")
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @Getter
    private CategoryEntity categoryEntity;

    @Column(name = "subcategory_name", nullable = false)
    @Getter
    @Setter
    private String subcategory_name;
}