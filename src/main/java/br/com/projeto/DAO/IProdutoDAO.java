package br.com.projeto.DAO;

import br.com.projeto.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Produto cadastrar(Produto produto);
    public Produto buscarPorId(Long id);
    public void excluir(Produto produto);
    public Produto alterar(Produto produto);
    public List<Produto> buscarTodos();
}
