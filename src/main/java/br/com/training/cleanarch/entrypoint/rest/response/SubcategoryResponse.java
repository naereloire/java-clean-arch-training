package br.com.training.cleanarch.entrypoint.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
