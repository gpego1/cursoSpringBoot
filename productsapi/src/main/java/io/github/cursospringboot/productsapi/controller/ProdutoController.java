package io.github.cursospringboot.productsapi.controller;
import io.github.cursospringboot.productsapi.model.Produto;
import io.github.cursospringboot.productsapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido " + produto);
        UUID uuid = UUID.randomUUID();
        produto.setId(uuid.toString());
        produtoRepository.save(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable String id, @RequestBody Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        produtoRepository.deleteById(id);
    }
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }


}
