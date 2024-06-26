import br.com.projeto.DAO.IProdutoDAO;
import br.com.projeto.DAO.ProdutoDAO;
import br.com.projeto.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    private IProdutoDAO produtoDAO;

    public ProdutoTest(){
        produtoDAO = new ProdutoDAO();
    }

    @After
    public void end(){
        List<Produto> list = produtoDAO.buscarTodos();
        list.forEach(produto -> produtoDAO.excluir(produto));
    }

    @Test
    public void cadastrar(){
        Produto produto = new Produto();
        produto.setNomeProduto("arroz");
        produto.setValor(20d);
        produto = produtoDAO.cadastrar(produto);
        assertNotNull(produto.getId());
    }

    @Test
    public void alterar(){
        Produto produto = new Produto();
        produto.setNomeProduto("arroz");
        produto.setValor(20d);
        produto = produtoDAO.cadastrar(produto);

        Produto produtoDB = produtoDAO.buscarPorId(produto.getId());
        assertNotNull(produtoDB);
        assertEquals(produto.getId(), produtoDB.getId());
        assertEquals(produto.getNomeProduto(), produtoDB.getNomeProduto());

        produtoDB.setNomeProduto("feijao");
        Produto produtoUp = produtoDAO.alterar(produtoDB);
        assertEquals("feijao", produtoUp.getNomeProduto());
    }

    @Test
    public void listarTodos() {
        Produto produto1 = new Produto();
        produto1.setNomeProduto("arroz");
        produto1.setValor(20d);
        produtoDAO.cadastrar(produto1);

        Produto produto2 = new Produto();
        produto2.setNomeProduto("feijão");
        produto2.setValor(15d);
        produtoDAO.cadastrar(produto2);

        List<Produto> produtos = produtoDAO.buscarTodos();
        assertNotNull(produtos);
        assertEquals(2, produtos.size());
    }

    @Test
    public void excluir() {
        Produto produto = new Produto();
        produto.setNomeProduto("arroz");
        produto.setValor(20d);
        produto = produtoDAO.cadastrar(produto);

        Produto produtoDB = produtoDAO.buscarPorId(produto.getId());
        assertNotNull(produtoDB);

        produtoDAO.excluir(produtoDB);
        Produto produtoExcluido = produtoDAO.buscarPorId(produto.getId());
        assertTrue(produtoExcluido == null);
    }


}