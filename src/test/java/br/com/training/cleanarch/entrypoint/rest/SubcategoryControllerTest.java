package br.com.training.cleanarch.entrypoint.rest;

import br.com.training.cleanarch.domain.CategoryEntity;
import br.com.training.cleanarch.domain.SubcategoryEntity;
import br.com.training.cleanarch.usecase.FindSubcategoryById;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class SubcategoryControllerTest {

    @MockBean
    private FindSubcategoryById findSubcategoryById;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /subcategory success")
    void testGetAllCategorySuccess() throws Exception {

        CategoryEntity categoryEntity = new CategoryEntity(1L, "Leitura");
        SubcategoryEntity subcategoryEntity = new SubcategoryEntity(1L, "Livros", categoryEntity);

        Mockito.doReturn(Lists.newArrayList(subcategoryEntity)).when(findSubcategoryById).findByCategoryId(1L);

        mockMvc.perform(get("/subcategory/1"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].subcategoria_id", is(1)))
                .andExpect(jsonPath("$[0].subcategoria_nome", is("Livros")));
    }
}
