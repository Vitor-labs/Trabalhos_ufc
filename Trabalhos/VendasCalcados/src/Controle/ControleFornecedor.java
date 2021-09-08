package Controle;

import java.util.ArrayList;
import DAO.DAOForncedor;
import Modelos.ModeloFornecedor;

public class ControleFornecedor {
    private DAOForncedor fornecedor = new DAOForncedor();

    public boolean salvarFornecedorControle(ModeloFornecedor prodMod) {
        return this.fornecedor.salvaFornecedorDAO(prodMod);
    }

    public boolean excluirFornecedorControle(int idProduto) {
        return this.fornecedor.excluirFornecedorDAO(idProduto);
    }

    public boolean alterarFornecedorControle(ModeloFornecedor prodMod) {
        return this.fornecedor.alterarFornecedorDAO(prodMod);
    }

    public ModeloFornecedor retornarFornecedorControle(int idProduto) {
        return this.fornecedor.retornarFornecedorDAO(idProduto);
    }

    public ArrayList<ModeloFornecedor> retornarListaFornecedorControle() {
        return this.fornecedor.retornarListaFornecedoresDAO();
    }
}
