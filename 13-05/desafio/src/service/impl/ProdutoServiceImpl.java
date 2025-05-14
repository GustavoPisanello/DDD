package service.impl;

import domain.Produto;
import repository.ProdutoRepository;
import service.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository repository;
    public Produto produto;

    public ProdutoServiceImpl(ProdutoRepository repository){
        this.repository = repository;
    }

    public void registrarProduto(String nome, double preco, Integer codigo){
        produto = new Produto(nome, preco, codigo);
    }
}
