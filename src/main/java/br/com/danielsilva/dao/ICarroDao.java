package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Carro;

import java.util.List;

public interface ICarroDao {

    public Carro cadastrar(Carro carro);

    public void excluir(Carro carro);

    public Carro buscarPorId(Long id);

    List<Carro> buscarTodos();
}
