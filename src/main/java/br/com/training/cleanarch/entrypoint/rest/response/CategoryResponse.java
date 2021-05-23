package br.com.training.cleanarch.entrypoint.rest.response;

//aqui crio uma resposta personalizada p/ o usuario

public class CategoryResponse {
    private Long categoria_id;
    private String categoria_nome;

    public CategoryResponse(Long categoria_id, String categoria_nome) {
        this.categoria_id = categoria_id;
        this.categoria_nome = categoria_nome;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }
}
