package repository.impl;

import domain.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoRepositoryImpl {
    private final Map<Integer, Produto> storage = new HashMap<>();

    public void save(Produto produto){
        storage.put(produto.getId(), produto);
    }

    public Produto findById(Integer id){
        return storage.get(id);
    }
}
