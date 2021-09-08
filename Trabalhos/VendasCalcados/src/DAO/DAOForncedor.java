package DAO;

import conecxoes.Conexao;
import Modelos.ModeloFornecedor;
import java.util.ArrayList;

public class DAOForncedor extends Conexao {
    public boolean salvaFornecedorDAO(ModeloFornecedor modForn) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO Fornecedor ( preco, codigoFornecedor, empresa, produto ) VALUES ( '"
                    + modForn.getPrecoFornecedor() + "', '" + modForn.getCodigo() + "', '" + modForn.getEmpresa()
                    + "', '" + modForn.getProduto() + "');");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirFornecedorDAO(int IdFornecedor) {
        try {
            this.conectar();
            return this.executeUpdateDelete("DELETE FROM Fornecedor WHERE idFornecedor = '" + IdFornecedor + "';");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarFornecedorDAO(ModeloFornecedor modForn) {
        try {
            this.conectar();
            return this.executeUpdateDelete("UPDATE Fornecedor SET codigoFornecedor = '" + modForn.getCodigo()
                    + "', preco = '" + modForn.getPrecoFornecedor() + "', empresa = '" + modForn.getEmpresa()
                    + "', produto = '" + modForn.getProduto() + "' WHERE idFornecedor = '" + modForn.getId() + "';");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModeloFornecedor retornarFornecedorDAO(int idFornecedor) {
        ModeloFornecedor modeloFornecedor = new ModeloFornecedor();
        try {
            this.conectar();
            this.executeSQL(
                    "SELECT codigoFornecedor, preco, empresa, produto, idFornecedor FROM fornecedor WHERE idFornecedor = '"
                            + idFornecedor + "';");

            while (this.getResult().next()) {
                modeloFornecedor.setCodigo(this.getResult().getString("codigoFornecedor"));
                modeloFornecedor.setPrecoFornecedor(this.getResult().getFloat("preco"));
                modeloFornecedor.setEmpresa(this.getResult().getString("empresa"));
                modeloFornecedor.setProduto(this.getResult().getString("produto"));
                modeloFornecedor.setId(this.getResult().getInt("idFornecedor"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modeloFornecedor;
    }

    public ArrayList<ModeloFornecedor> retornarListaFornecedoresDAO() {
        ArrayList<ModeloFornecedor> listaFornecedores = new ArrayList<>();
        ModeloFornecedor modeloFornecedor = new ModeloFornecedor();
        try {
            this.conectar();
            this.executeSQL("SELECT codigoFornecedor, preco, empresa, produto, idFornecedor FROM fornecedor;");

            while (this.getResult().next()) {
                modeloFornecedor = new ModeloFornecedor();
                modeloFornecedor.setCodigo(this.getResult().getString("codigoFornecedor"));
                modeloFornecedor.setPrecoFornecedor(this.getResult().getFloat("preco"));
                modeloFornecedor.setEmpresa(this.getResult().getString("empresa"));
                modeloFornecedor.setProduto(this.getResult().getString("produto"));
                modeloFornecedor.setId(this.getResult().getInt("idFornecedor"));

                listaFornecedores.add(modeloFornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaFornecedores;
    }
}