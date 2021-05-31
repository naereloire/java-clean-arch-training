package br.com.training.cleanarch.entrypoint.rest;

import br.com.training.cleanarch.domain.CategoryEntity;
import br.com.training.cleanarch.entrypoint.rest.response.CategoryResponse;
import br.com.training.cleanarch.usecase.FindCategory;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private FindCategory findCategory;

    public CategoryController(FindCategory findCategory) {
        this.findCategory = findCategory;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 403, message = "não tem permissão"),
            @ApiResponse(code = 500, message = "erro inesperado"),
    })
    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public List<CategoryResponse> getAllCategories() {
        List<CategoryEntity> categoryList = findCategory.findAllCategories();
        return CategoryResponse.mapToCategoryResponse(categoryList);
    }
}