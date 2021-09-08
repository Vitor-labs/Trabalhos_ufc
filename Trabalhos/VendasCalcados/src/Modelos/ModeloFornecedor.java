package Modelos;

public class ModeloFornecedor {
    private int id;
    private String codigo;
    private float precoFornecedor;
    private String empresa;
    private String produto;

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public double getPrecoFornecedor() {
        return precoFornecedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecoFornecedor(float preco) {
        this.precoFornecedor = preco;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
