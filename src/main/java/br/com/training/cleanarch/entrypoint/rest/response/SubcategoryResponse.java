package br.com.training.cleanarch.entrypoint.rest.response;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class SubcategoryResponse {
    @JsonProperty("subcategoria_id")
    @Getter
    private Long subcategoryId;

    @JsonProperty("subcategoria_nome")
    @Getter
    @Setter
    private String subcategoryName;

    @JsonProperty("categorie_name")
    @Getter
    private String categoryName;

    public static List<SubcategoryResponse> mapToSubcategoryResponse(List<SubcategoryEntity> subcategoryEntityList) {
        return subcategoryEntityList.stream().map(subcategoryEntity -> new SubcategoryResponse(
                subcategoryEntity.getId(),
                subcategoryEntity.getSubcategory_name(),
                subcategoryEntity.getCategoryEntity().getCategory_name()
                )).collect(Collectors.toList());
    }
}