package br.com.training.cleanarch.entrypoint.rest.response;

import br.com.training.cleanarch.domain.ProductEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    @JsonProperty("produto_id")
    @Getter
    private Long productId;

    @JsonProperty("produto_nome")
    @Getter
    @Setter
    private String productName;

    @JsonProperty("preco_produto")
    @Getter
    @Setter
    private Long productPrice;

    @JsonProperty("subcategory_name")
    @Getter
    private String subcategoryName;

    public static List<ProductResponse> mapToProductResponse(List<ProductEntity> productEntityList) {
        return productEntityList.stream().map(productEntity -> new ProductResponse(
                productEntity.getId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getSubcategoryEntity().getSubcategory_name()
        )).collect(Collectors.toList());
    }

}
