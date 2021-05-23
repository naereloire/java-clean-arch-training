package br.com.training.cleanarch.entrypoint.rest;

import br.com.training.cleanarch.domain.CategoryEntity;
import br.com.training.cleanarch.entrypoint.rest.response.CategoryResponse;
import br.com.training.cleanarch.usecase.FindCategory;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            CategoryEntity categoryObj = categoryList.get(i);
            CategoryResponse categoryResponseObject = new CategoryResponse(
                    categoryObj.getId(),
                    categoryObj.getCategory_name());
            categoryResponses.add(categoryResponseObject);
        }
        return categoryResponses;
    }
}

//aqui fazer um for para percorrer a lista de category list
//para cada item de category entity criar um novo item category response
//adicionar o item category response criado na lista de category Response
//marcar papo na agenda gabs seg