package View;

import Modelos.ModeloFornecedor;
import Controle.ControleFornecedor;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class viewCadastroFornecedor extends JFrame {

    // Variables declaration - do not modify
    ArrayList<ModeloFornecedor> listaModeloFornecedor;
    ModeloFornecedor modeloFornecedor;
    ControleFornecedor controleFornecedor;

    private JButton botaoAlterar;
    private JButton botaoCadastrar;
    private JButton botaoCancelar;
    private JButton botaoExcluir;
    private JButton botaoNovo;
    private JButton botaoPesquisar;
    private JPanel painel;
    private JLabel labelEmpresa;
    private JLabel labelPesquisar;
    private JLabel labelPreco;
    private JLabel labelProduto;
    private JLabel labelCodigo;
    private JScrollPane scroll;
    private JTable tabelaFornecedor;
    private JTextField textoCodigo;
    private JTextField textoPesquisar;
    private JTextField textoEmpresa;
    private JTextField textoPreco;
    private JTextField textoProduto;
    // End of variables declaration

    public viewCadastroFornecedor() {
        initComponents();
        carregarFornecedores();
        onOffCampos(false);
    }

    private void carregarFornecedores() {
        listaModeloFornecedor = new ArrayList<ModeloFornecedor>();
        controleFornecedor = new ControleFornecedor();

        listaModeloFornecedor = controleFornecedor.retornarListaFornecedorControle();
        DefaultTableModel model = (DefaultTableModel) tabelaFornecedor.getModel();
        model.setNumRows(0);

        int count = listaModeloFornecedor.size();
        for (int i = 0; i < count; i++) {
            model.addRow(new Object[] { listaModeloFornecedor.get(i).getCodigo(),
                    listaModeloFornecedor.get(i).getEmpresa(), listaModeloFornecedor.get(i).getProduto(),
                    listaModeloFornecedor.get(i).getPrecoFornecedor(), listaModeloFornecedor.get(i).getId() });
        }
    }

    private void limpaTexto() {
        textoProduto.setText("");
        textoPreco.setText("");
        textoEmpresa.setText("");
        textoCodigo.setText("");
    }

    private void onOffCampos(boolean is) {
        textoCodigo.setEnabled(is);
        textoPesquisar.setEnabled(is);
        textoProduto.setEnabled(is);
        textoPreco.setEnabled(is);
        textoEmpresa.setEnabled(is);
    }

    private void initComponents() {

        controleFornecedor = new ControleFornecedor();
        modeloFornecedor = new ModeloFornecedor();
        listaModeloFornecedor = new ArrayList<ModeloFornecedor>();

        painel = new JPanel();
        labelEmpresa = new JLabel();
        labelProduto = new JLabel();
        labelPesquisar = new JLabel();
        labelPreco = new JLabel();
        labelCodigo = new JLabel();
        textoCodigo = new JTextField();
        textoEmpresa = new JTextField();
        textoProduto = new JTextField();
        textoPreco = new JTextField();
        textoPesquisar = new JTextField();
        scroll = new JScrollPane();
        tabelaFornecedor = new JTable();
        botaoPesquisar = new JButton();
        botaoExcluir = new JButton();
        botaoAlterar = new JButton();
        botaoNovo = new JButton();
        botaoCancelar = new JButton();
        botaoCadastrar = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        painel.setBackground(new Color(51, 51, 51));
        textoCodigo.setToolTipText("CPF ou CNPJ da Fornecedora");
        painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel.setForeground(new Color(60, 63, 65));

        textoCodigo.setForeground(Color.LIGHT_GRAY);
        textoCodigo.setBackground(new Color(51, 51, 51));
        textoCodigo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoEmpresa.setForeground(Color.LIGHT_GRAY);
        textoEmpresa.setToolTipText("Empresa Fornecedora");
        textoEmpresa.setBackground(new Color(51, 51, 51));
        textoEmpresa.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoProduto.setForeground(Color.LIGHT_GRAY);
        textoProduto.setToolTipText("ID do produto Cadastrado");
        textoProduto.setBackground(new Color(51, 51, 51));
        textoProduto.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoPreco.setForeground(Color.LIGHT_GRAY);
        textoPreco.setToolTipText("Preço do Lote do produto");
        textoPreco.setBackground(new Color(51, 51, 51));
        textoPreco.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoPesquisar.setForeground(Color.LIGHT_GRAY);
        textoPesquisar.setBackground(new Color(51, 51, 51));
        textoPesquisar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        labelCodigo.setText("Código");
        labelCodigo.setBackground(new Color(51, 51, 51));
        labelCodigo.setForeground(Color.LIGHT_GRAY);
        labelCodigo.setOpaque(true);

        labelEmpresa.setText("Empresa");
        labelEmpresa.setBackground(new Color(51, 51, 51));
        labelEmpresa.setForeground(Color.LIGHT_GRAY);
        labelEmpresa.setOpaque(true);

        labelProduto.setText("Produto");
        labelProduto.setBackground(new Color(51, 51, 51));
        labelProduto.setForeground(Color.LIGHT_GRAY);
        labelProduto.setOpaque(true);

        labelPreco.setText("Preço");
        labelPreco.setBackground(new Color(51, 51, 51));
        labelPreco.setForeground(Color.LIGHT_GRAY);
        labelPreco.setOpaque(true);

        labelPesquisar.setText("Pesquisar");
        labelPesquisar.setBackground(new Color(51, 51, 51));
        labelPesquisar.setForeground(Color.LIGHT_GRAY);
        labelPesquisar.setOpaque(true);

        tabelaFornecedor.setBackground(new Color(51, 51, 51));
        tabelaFornecedor.setForeground(Color.LIGHT_GRAY);
        tabelaFornecedor.setModel(new DefaultTableModel(
                new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
                        { null, null, null, null, null }, { null, null, null, null, null },
                        { null, null, null, null, null }, { null, null, null, null, null },
                        { null, null, null, null, null }, { null, null, null, null, null } },
                new String[] { "Codigo", "Empresa", "Produto", "Preço", "ID" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        scroll.setViewportView(tabelaFornecedor);
        scroll.setBackground(Color.darkGray);
        scroll.setForeground(Color.LIGHT_GRAY);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.setBackground(Color.darkGray);
        botaoCancelar.setForeground(Color.LIGHT_GRAY);
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoNovo.setText("Novo");
        botaoNovo.setBackground(Color.darkGray);
        botaoNovo.setForeground(Color.LIGHT_GRAY);
        botaoNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setBackground(Color.darkGray);
        botaoCadastrar.setForeground(Color.LIGHT_GRAY);
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoCadastroActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.setBackground(Color.darkGray);
        botaoExcluir.setForeground(Color.LIGHT_GRAY);
        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.setBackground(Color.darkGray);
        botaoAlterar.setForeground(Color.LIGHT_GRAY);
        botaoAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setBackground(Color.darkGray);
        botaoPesquisar.setForeground(Color.LIGHT_GRAY);
        botaoPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup().addContainerGap().addGroup(painelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelLayout.createSequentialGroup().addGroup(painelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(painelLayout.createSequentialGroup().addGroup(painelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(painelLayout.createSequentialGroup().addGap(10, 10, 10)
                                                .addGroup(painelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(painelLayout.createSequentialGroup()
                                                                .addComponent(labelCodigo).addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(textoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                74, Short.MAX_VALUE))
                                                .addGap(20, 20, 20)
                                                .addGroup(painelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelEmpresa).addComponent(textoEmpresa,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(painelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelProduto).addComponent(textoProduto,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout
                                                .createSequentialGroup().addGap(13, 13, 13)
                                                .addGroup(painelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(textoPesquisar)
                                                        .addGroup(painelLayout.createSequentialGroup()
                                                                .addGroup(painelLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelPesquisar)
                                                                        .addGroup(painelLayout.createSequentialGroup()
                                                                                .addComponent(botaoExcluir,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        74,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(65, 65, 65)
                                                                                .addComponent(botaoAlterar,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        74,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                        .addGap(18, 18, 18)
                                        .addGroup(painelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(painelLayout.createSequentialGroup().addGap(6, 6, 6)
                                                        .addComponent(labelPreco))
                                                .addComponent(textoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)))
                                .addContainerGap())
                        .addGroup(painelLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(botaoCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoCadastrar).addGap(14, 14, 14)))));
        painelLayout.setVerticalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup().addGap(14, 14, 14)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEmpresa).addComponent(labelProduto).addComponent(labelPreco)
                                .addComponent(labelCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoProduto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoPreco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(labelPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botaoPesquisar))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoExcluir).addComponent(botaoAlterar).addComponent(botaoNovo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botaoCadastrar).addComponent(botaoCancelar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void botaoExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = tabelaFornecedor.getSelectedRow();
        int codigoFornecedorSelecionado = (int) tabelaFornecedor.getValueAt(linhaSelecionada, 0);

        if (controleFornecedor.excluirFornecedorControle(codigoFornecedorSelecionado)) {
            JOptionPane.showMessageDialog(this, "Fornecedor Excluido");
            this.carregarFornecedores();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Excluir Fornecedor");
        }
    }

    private void botaoCancelarActionPerformed(ActionEvent evt) {
        this.onOffCampos(false);
        this.limpaTexto();
    }

    private void botaoNovoActionPerformed(ActionEvent evt) {
        this.onOffCampos(true);
    }

    private void botaoPesquisarActionPerformed(ActionEvent evt) {
        onOffCampos(false);
        DefaultTableModel model = (DefaultTableModel) this.tabelaFornecedor.getModel();
        final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
        this.tabelaFornecedor.setRowSorter(rowSorter);
        String entrada = textoPesquisar.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter(entrada, 1));
    }

    private void botaoAlterarActionPerformed(ActionEvent evt) {
        int linhaSelecionada = tabelaFornecedor.getSelectedRow();
        int codigoProdutoSelecionada = (int) tabelaFornecedor.getValueAt(linhaSelecionada, 0);

        try {
            modeloFornecedor = controleFornecedor.retornarFornecedorControle(codigoProdutoSelecionada);
            onOffCampos(true);

            this.textoEmpresa.setText(String.valueOf(modeloFornecedor.getEmpresa()));
            this.textoPreco.setText(String.valueOf(modeloFornecedor.getPrecoFornecedor()));
            this.textoProduto.setText(String.valueOf(modeloFornecedor.getProduto()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código invalido ou nenhum selecionado", "Aviso",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void botaoCadastroActionPerformed(ActionEvent evt) {
        modeloFornecedor.setCodigo(this.textoCodigo.getText());
        modeloFornecedor.setPrecoFornecedor(Float.parseFloat(this.textoPreco.getText()));
        modeloFornecedor.setEmpresa(this.textoEmpresa.getText());
        modeloFornecedor.setProduto(this.textoProduto.getText());

        if (controleFornecedor.salvarFornecedorControle(modeloFornecedor)) {
            JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com Sucesso");
            this.carregarFornecedores();
            this.onOffCampos(false);
            this.limpaTexto();
        } else {
            JOptionPane.showMessageDialog(this, "Erro no Cadastro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewCadastroFornecedor().setVisible(true);
            }
        });
    }
}
