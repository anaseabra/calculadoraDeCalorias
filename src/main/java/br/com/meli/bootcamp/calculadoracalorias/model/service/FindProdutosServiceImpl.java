package br.com.meli.bootcamp.calculadoracalorias.model.service;

import br.com.meli.bootcamp.calculadoracalorias.model.dto.IngredienteDTO;
import br.com.meli.bootcamp.calculadoracalorias.model.dto.ProdutoDTO;
import br.com.meli.bootcamp.calculadoracalorias.model.repository.IngredientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProdutosServiceImpl implements FindProdutosService {

    private final IngredientesRepository repository;

    public FindProdutosServiceImpl(IngredientesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProdutoDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public ProdutoDTO findByName(String name) {
        return repository.findIngredientesByName(name);
    }

    public void calcularCaloriasTotais(ProdutoDTO produtoDTO){
        int caloriasTotais = 0;
        for (IngredienteDTO ingrediente: produtoDTO.getIngredientes()){
            caloriasTotais += ingrediente.getCalories();
        }

        produtoDTO.setCaloriasTotais(caloriasTotais);
    }
}
