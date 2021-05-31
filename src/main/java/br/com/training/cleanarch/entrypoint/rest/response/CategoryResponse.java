package br.com.training.cleanarch.entrypoint.rest.response;

import br.com.training.cleanarch.domain.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    @JsonProperty("categoria_id")
    @Getter
    private Long categoryId;

    @JsonProperty("categoria_nome")
    @Getter
    @Setter
    private String categoryName;

    public static List<CategoryResponse> mapToCategoryResponse(List<CategoryEntity> categoryEntity) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (CategoryEntity categoryObj : categoryEntity) {
            CategoryResponse categoryResponseObject = new CategoryResponse(
                    categoryObj.getId(),
                    categoryObj.getCategory_name());
            categoryResponses.add(categoryResponseObject);
        }
        return categoryResponses;
    }
//    public static List<CategoryResponse> mapToCategoryResponseDois(List<CategoryEntity> categoryEntityList) {
//        return categoryEntityList.stream().map(categoryEntity -> new CategoryResponse(categoryEntity.getId(),
//                categoryEntity.getCategory_name())).collect(Collectors.toList());
//    }
}
//aqui crio uma resposta personalizada p/ o usuario
//[Boa pratica]usar json property em classe de response