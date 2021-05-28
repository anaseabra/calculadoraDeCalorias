package br.com.meli.bootcamp.calculadoracalorias.controller;

import br.com.meli.bootcamp.calculadoracalorias.model.ProdutoDTO;
import br.com.meli.bootcamp.calculadoracalorias.model.service.FindProdutosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraDeCaloriasController {

    @Autowired
    private FindProdutosServiceImpl findProdutosService;

    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> getProdutos(){

        return ResponseEntity.status(200).body(findProdutosService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable String name){

        return ResponseEntity.status(200).body(findProdutosService.findByName(name));
    }
}
