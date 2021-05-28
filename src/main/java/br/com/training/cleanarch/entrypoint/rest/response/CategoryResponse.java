package br.com.training.cleanarch.entrypoint.rest.response;

//aqui crio uma resposta personalizada p/ o usuario
//[Boa pratica]usar json property em classe de response

import br.com.training.cleanarch.domain.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryResponse {
    @JsonProperty("categoria_id")
    private Long categoryId;
    @JsonProperty("categoria_nome")
    private String categoryName;

    public CategoryResponse(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static List<CategoryResponse> mapToCategoryResponse(List<CategoryEntity> categoryEntity) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (int i = 0; i < categoryEntity.size(); i++) {
            CategoryEntity categoryObj = categoryEntity.get(i);
            CategoryResponse categoryResponseObject = new CategoryResponse(
                    categoryObj.getId(),
                    categoryObj.getCategory_name());
            categoryResponses.add(categoryResponseObject);
        }
        return categoryResponses;
    }

    //com java 8
//    public static List<CategoryResponse> mapToCategoryResponseDois(List<CategoryEntity> categoryEntityList) {
//        return categoryEntityList.stream().map(categoryEntity -> new CategoryResponse(categoryEntity.getId(),
//                categoryEntity.getCategory_name())).collect(Collectors.toList());
//    }
}
