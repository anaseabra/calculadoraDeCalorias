package br.com.meli.bootcamp.calculadoracalorias.model.service;

import br.com.meli.bootcamp.calculadoracalorias.model.dto.ProdutoDTO;

import java.util.List;

public interface FindProdutosService {

    public List<ProdutoDTO> findAll();
    public ProdutoDTO findByName (String name);
}
