package br.com.training.cleanarch.entrypoint.rest;

import br.com.training.cleanarch.domain.SubcategoryEntity;
import br.com.training.cleanarch.entrypoint.rest.response.SubcategoryResponse;
import br.com.training.cleanarch.usecase.FindSubcategoryById;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubcategoryController {

    private final FindSubcategoryById findSubcategoryById;

    //injeção de dep no proprio construtor
    public SubcategoryController(FindSubcategoryById findSubcategoryById) {
        this.findSubcategoryById = findSubcategoryById;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 403, message = "não tem permissão"),
            @ApiResponse(code = 500, message = "erro inesperado"),
    })

    @RequestMapping(value = "/subcategory/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<SubcategoryResponse> getSubcategoryByParentId(@PathVariable("id") Long id) {
        List<SubcategoryEntity> subcategoryList = findSubcategoryById.findByCategoryId(id);
        return SubcategoryResponse.mapToSubcategoryResponse(subcategoryList);
    }
}
