package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Acessorios;

public interface IAcessoriosDao {

    public Acessorios cadastrar(Acessorios acessorios);

    void excluir(Acessorios acessorios);
}
