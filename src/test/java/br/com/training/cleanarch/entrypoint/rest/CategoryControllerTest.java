package br.com.training.cleanarch.entrypoint.rest;

import br.com.training.cleanarch.domain.CategoryEntity;
import br.com.training.cleanarch.usecase.FindCategory;
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

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @MockBean
    private FindCategory findCategory;

    @Autowired
    private MockMvc mockMvc;

    //Nesse bloco setup mock
    @Test
    @DisplayName("GET /category success")
    void testGetAllCategorySuccess() throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity(1L, "leitura");
        Mockito.doReturn(Lists.newArrayList(categoryEntity)).when(findCategory).findAllCategories();

        mockMvc.perform(get("/category"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].categoria_id", is(1)))
                .andExpect(jsonPath("$[0].categoria_nome", is("leitura")));
    }
}
