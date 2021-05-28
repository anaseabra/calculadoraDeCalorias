package br.com.meli.bootcamp.calculadoracalorias.model.repository;

import br.com.meli.bootcamp.calculadoracalorias.model.ProdutoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientesRepositoryImpl implements IngredientesRepository{

    @Override
    public ProdutoDTO findIngredientesByName(String name) {

        List<ProdutoDTO> produtos = new ArrayList<>();

        produtos = loadDataBase();
        ProdutoDTO result = null;
        if(produtos != null){
            Optional<ProdutoDTO> item = produtos.stream()
                    .filter(produto -> produto.getName().equals(name))
                    .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }

        return result;
    }

    @Override
    public List<ProdutoDTO> findAll() {

        List<ProdutoDTO> ingredienteDTOS = loadDataBase();
        return ingredienteDTOS;
    }

    private List<ProdutoDTO> loadDataBase() {

        File file = null;
        List<ProdutoDTO> produtos = null;
        try{
            file = ResourceUtils.getFile("src/main/resources/food.json");

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<ProdutoDTO>> typeRef = new TypeReference<List<ProdutoDTO>>() {};

            produtos = objectMapper.readValue(file, typeRef);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
