package br.com.training.cleanarch.entrypoint.rest;

import br.com.training.cleanarch.domain.ProductEntity;
import br.com.training.cleanarch.entrypoint.rest.response.ProductResponse;
import br.com.training.cleanarch.usecase.FindProducts;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final FindProducts findProducts;

    public ProductController(FindProducts findProducts) {
        this.findProducts = findProducts;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 403, message = "não tem permissão"),
            @ApiResponse(code = 500, message = "erro inesperado"),
    })

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> productList = findProducts.findAllProducts();
        return ProductResponse.mapToProductResponse(productList);
    }
}
