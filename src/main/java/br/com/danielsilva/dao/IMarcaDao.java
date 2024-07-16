package br.com.danielsilva.dao;

import br.com.danielsilva.domain.Carro;
import br.com.danielsilva.domain.Marca;

public interface IMarcaDao {

    public Marca cadastrar(Marca marca);
    public void excluir(Marca marca);
    public Marca buscarPorId(Long id);


}
