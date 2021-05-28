package br.com.meli.bootcamp.calculadoracalorias.model.repository;


import br.com.meli.bootcamp.calculadoracalorias.model.ProdutoDTO;

import java.util.List;

public interface IngredientesRepository {

    public ProdutoDTO findIngredientesByName(String name);
    public List<ProdutoDTO> findAll();

}
