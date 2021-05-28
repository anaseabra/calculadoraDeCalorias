package br.com.meli.bootcamp.calculadoracalorias.model;

import java.util.List;

public class ProdutoDTO {

    private String name;
    private List<IngredienteDTO> ingredientes;
    private int caloriasTotais;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredienteDTOS) {
        this.ingredientes = ingredienteDTOS;
    }

    public int getCalorias() {
        return this.caloriasTotais;
    }

    public void setCaloriasTotais(int caloriasTotais) {
        this.caloriasTotais = caloriasTotais;
    }
}
