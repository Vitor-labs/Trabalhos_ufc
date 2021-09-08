package Controle;

import java.util.ArrayList;

import DAO.DAOProduto;
import Modelos.ModeloProdutos;

public class ControleProdutos {
    private DAOProduto produtoDao = new DAOProduto();

    public boolean salvarProdutosControle(ModeloProdutos prodMod) {
        return this.produtoDao.salvarProdutoDAO(prodMod);
    }

    public boolean excluirProdutosControle(int idProduto) {
        return this.produtoDao.excluirProdutoDAO(idProduto);
    }

    public boolean alterarProdutoControle(ModeloProdutos prodMod) {
        return this.produtoDao.alterarProdutoDAO(prodMod);
    }

    public ModeloProdutos retornarProdutoControle(int idProduto) {
        return this.produtoDao.retornarProdutoDAO(idProduto);
    }

    public ArrayList<ModeloProdutos> retornarListaProdutoControle() {
        return this.produtoDao.retornarListaProdutosDAO();
    }
}
