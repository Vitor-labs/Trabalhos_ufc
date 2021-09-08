package DAO;

import Modelos.ModeloProdutos;
import conecxoes.Conexao;
import java.util.ArrayList;

public class DAOProduto extends Conexao {

    public boolean salvarProdutoDAO(ModeloProdutos prodMod) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO produto ( modelo, precoProduto, quantidade, marca, tamanho, cor, genero ) VALUES ('"
                            + prodMod.getModelo() + "', '" + prodMod.getPrecoProduto() + "', '"
                            + prodMod.getQtdEstoque() + "', '" + prodMod.getMarca() + "', '" + prodMod.getTamanho()
                            + "', '" + prodMod.getCor() + "', '" + prodMod.getGenero() + "');");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirProdutoDAO(int IdProduto) {
        try {
            this.conectar();
            return this.executeUpdateDelete("DELETE FROM produto WHERE codigo = '" + IdProduto + "';");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarProdutoDAO(ModeloProdutos prodMod) {
        try {
            this.conectar();
            return this.executeUpdateDelete("UPDATE produto SET " + "modelo = '" + prodMod.getModelo() + "',"
                    + "precoProduto = '" + prodMod.getPrecoProduto() + "'," + "quantidade = '" + prodMod.getQtdEstoque()
                    + "'" + " WHERE codigo = '" + prodMod.getCodigo() + "';");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModeloProdutos retornarProdutoDAO(int IdProduto) {
        ModeloProdutos modelProdutos = new ModeloProdutos();
        try {
            this.conectar();
            this.executeSQL("SELECT" + " codigo, " + " marca," + " modelo," + " cor," + " tamanho," + " genero,"
                    + " quantidade," + " preco" + " FROM Produto WHERE codigo = '" + IdProduto + "';");

            while (this.getResult().next()) {
                modelProdutos.setCodigo(this.getResult().getInt(1));
                modelProdutos.setMarca(this.getResult().getString(1));
                modelProdutos.setModelo(this.getResult().getString(1));
                modelProdutos.setCor(this.getResult().getString(1));
                modelProdutos.setTamanho(this.getResult().getString(1));
                modelProdutos.setGenero(this.getResult().getString(1));
                modelProdutos.setQtdEstoque(this.getResult().getInt(1));
                modelProdutos.setPrecoProduto(this.getResult().getFloat(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    public ArrayList<ModeloProdutos> retornarListaProdutosDAO() {
        ArrayList<ModeloProdutos> listaModelProdutos = new ArrayList<>();
        ModeloProdutos modelProdutos = new ModeloProdutos();
        try {
            this.conectar();
            this.executeSQL(
                    "SELECT codigo, modelo, marca, precoProduto, tamanho, cor, genero, quantidade FROM produto;");

            while (this.getResult().next()) {
                modelProdutos = new ModeloProdutos();
                modelProdutos.setCodigo(this.getResult().getInt("codigo"));
                modelProdutos.setModelo(this.getResult().getString("modelo"));
                modelProdutos.setMarca(this.getResult().getString("marca"));
                modelProdutos.setPrecoProduto(this.getResult().getInt("precoProduto"));
                modelProdutos.setTamanho(this.getResult().getString("tamanho"));
                modelProdutos.setCor(this.getResult().getString("cor"));
                modelProdutos.setGenero(this.getResult().getString("genero"));
                modelProdutos.setQtdEstoque(this.getResult().getInt("quantidade"));

                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }

    public boolean alterarEstoqueProdutosDAO(ArrayList<ModeloProdutos> listaModeloProdutos) {
        try {
            this.conectar();
            for (int i = 0; i < listaModeloProdutos.size(); i++) {
                this.executeUpdateDelete(
                        "UPDATE produto SET " + "estoque = '" + listaModeloProdutos.get(i).getQtdEstoque() + "'"
                                + " WHERE codigo = '" + listaModeloProdutos.get(i).getCodigo() + "'");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
