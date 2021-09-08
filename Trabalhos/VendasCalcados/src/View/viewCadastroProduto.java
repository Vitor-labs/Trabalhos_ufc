package View;

import Modelos.ModeloProdutos;
import Controle.ControleProdutos;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class viewCadastroProduto extends JFrame {

    // Variables declaration - do not modify
    ArrayList<ModeloProdutos> listaModeloProduto;
    ModeloProdutos modeloProduto;
    ControleProdutos controleProdutos;

    private JButton botaoCancelar;
    private JButton botaoNovo;
    private JButton botaoCadastrar;
    private JButton botaoExcluir;
    private JButton botaoPesquisar;
    private JButton botaoAlterar;
    private JComboBox<String> comboBoxGenero;
    private JComboBox<String> comboBoxTamanho;
    private JLabel labelMarca;
    private JLabel labelGenero;
    private JLabel labelPreco;
    private JLabel labelModelo;
    private JLabel labelCor;
    private JLabel labelTamanho;
    private JLabel labelQuantidade;
    private JLabel labelPesquisa;
    private JPanel painelCadastro;
    private JPanel painelComboBox;
    private JPanel painel;
    private JScrollPane scroll;
    private JTable tabelaProdutos;
    private JTextField textoPesquisa;
    private JTextField textoQuantidade;
    private JTextField textoPreco;
    private JTextField textoModelo;
    private JTextField textoCor;
    private JTextField textoMarca;
    // End of variables declaration

    public viewCadastroProduto() {
        initComponents();
        carregarProdutos();
        onOffCampos(false);

        listaModeloProduto = new ArrayList<>();
        modeloProduto = new ModeloProdutos();
        controleProdutos = new ControleProdutos();
    }

    private void limpaTexto() {
        textoQuantidade.setText("");
        textoPreco.setText("");
        textoModelo.setText("");
        textoCor.setText("");
        textoMarca.setText("");
    }

    private void carregarProdutos() {
        listaModeloProduto = new ArrayList<ModeloProdutos>();
        controleProdutos = new ControleProdutos();

        listaModeloProduto = controleProdutos.retornarListaProdutoControle();
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        model.setNumRows(0);

        int count = listaModeloProduto.size();
        for (int i = 0; i < count; i++) {
            model.addRow(new Object[] { listaModeloProduto.get(i).getCodigo(), listaModeloProduto.get(i).getMarca(),
                    listaModeloProduto.get(i).getModelo(), listaModeloProduto.get(i).getCor(),
                    listaModeloProduto.get(i).getQtdEstoque(), listaModeloProduto.get(i).getPrecoProduto(),
                    listaModeloProduto.get(i).getTamanho(), listaModeloProduto.get(i).getGenero(), });
        }
    }

    private void onOffCampos(boolean is) {
        textoMarca.setEnabled(is);
        textoModelo.setEnabled(is);
        textoCor.setEnabled(is);
        textoPreco.setEnabled(is);
        textoQuantidade.setEnabled(is);
        comboBoxTamanho.setEnabled(is);
        comboBoxGenero.setEnabled(is);
    }

    private void initComponents() {

        painelCadastro = new JPanel();
        painelComboBox = new JPanel();
        painel = new JPanel();
        scroll = new JScrollPane();
        tabelaProdutos = new JTable();
        botaoCancelar = new JButton();
        botaoNovo = new JButton();
        botaoCadastrar = new JButton();
        botaoExcluir = new JButton();
        botaoAlterar = new JButton();
        botaoPesquisar = new JButton();
        textoPreco = new JTextField();
        textoModelo = new JTextField();
        textoCor = new JTextField();
        textoQuantidade = new JTextField();
        textoPesquisa = new JTextField();
        textoMarca = new JTextField();
        labelMarca = new JLabel();
        labelPreco = new JLabel();
        labelModelo = new JLabel();
        labelCor = new JLabel();
        labelTamanho = new JLabel();
        labelGenero = new JLabel();
        labelPesquisa = new JLabel();
        labelQuantidade = new JLabel();
        comboBoxTamanho = new JComboBox<>();
        comboBoxGenero = new JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        painelCadastro.setBackground(new Color(51, 51, 51));
        painelCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelCadastro.setForeground(new Color(60, 63, 65));
        painelCadastro.setToolTipText("");

        painelComboBox.setBackground(new Color(51, 51, 51));
        painelComboBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelComboBox.setForeground(new Color(60, 63, 65));
        painelComboBox.setToolTipText("");

        labelPreco.setText("Preço");
        labelPreco.setBackground(new Color(51, 51, 51));
        labelPreco.setForeground(Color.LIGHT_GRAY);
        labelPreco.setOpaque(true);

        labelModelo.setText("Modelo");
        labelModelo.setBackground(new Color(51, 51, 51));
        labelModelo.setForeground(Color.LIGHT_GRAY);
        labelModelo.setOpaque(true);

        labelCor.setText("Cor");
        labelCor.setBackground(new Color(51, 51, 51));
        labelCor.setForeground(Color.LIGHT_GRAY);
        labelCor.setOpaque(true);

        labelQuantidade.setText("Quantidade");
        labelQuantidade.setBackground(new Color(51, 51, 51));
        labelQuantidade.setForeground(Color.LIGHT_GRAY);
        labelQuantidade.setOpaque(true);

        labelMarca.setText("Marca");
        labelMarca.setBackground(new Color(51, 51, 51));
        labelMarca.setForeground(Color.LIGHT_GRAY);
        labelMarca.setOpaque(true);

        labelGenero.setText("Gênero");
        labelGenero.setBackground(new Color(51, 51, 51));
        labelGenero.setForeground(Color.LIGHT_GRAY);
        labelGenero.setOpaque(true);

        labelTamanho.setText("Tamanho");
        labelTamanho.setBackground(new Color(51, 51, 51));
        labelTamanho.setForeground(Color.LIGHT_GRAY);
        labelTamanho.setOpaque(true);

        labelPesquisa.setText("Pesquisa");
        labelPesquisa.setBackground(new Color(51, 51, 51));
        labelPesquisa.setForeground(Color.LIGHT_GRAY);
        labelPesquisa.setOpaque(true);

        textoCor.setBackground(new Color(51, 51, 51));
        textoCor.setForeground(new Color(153, 153, 153));
        textoCor.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoQuantidade.setForeground(Color.LIGHT_GRAY);
        textoQuantidade.setBackground(new Color(51, 51, 51));
        textoQuantidade.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoPreco.setForeground(Color.LIGHT_GRAY);
        textoPreco.setBackground(new Color(51, 51, 51));
        textoPreco.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoMarca.setForeground(Color.LIGHT_GRAY);
        textoMarca.setBackground(new Color(51, 51, 51));
        textoMarca.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoModelo.setForeground(Color.LIGHT_GRAY);
        textoModelo.setBackground(new Color(51, 51, 51));
        textoModelo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoPesquisa.setForeground(Color.LIGHT_GRAY);
        textoPesquisa.setBackground(new Color(51, 51, 51));
        textoPesquisa.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        tabelaProdutos.setModel(new DefaultTableModel(new Object[][] {
                { null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null } },
                new String[] { "ID", "Marca", "Modelo", "Cor", "Quantidade", "Preço", "Tamanho", "Gênero" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        scroll.setViewportView(tabelaProdutos);

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

        comboBoxTamanho.setModel(new DefaultComboBoxModel<>(new String[] { " PP ", " P ", " M ", " G ", " GG " }));
        comboBoxTamanho.setBackground(Color.darkGray);
        comboBoxTamanho.setForeground(Color.LIGHT_GRAY);

        comboBoxGenero.setModel(new DefaultComboBoxModel<>(new String[] { "M", "F", "U" }));
        comboBoxGenero.setForeground(Color.LIGHT_GRAY);
        comboBoxGenero.setBackground(Color.darkGray);

        javax.swing.GroupLayout painelComboBoxLayout = new javax.swing.GroupLayout(painelComboBox);
        painelComboBox.setLayout(painelComboBoxLayout);
        painelComboBoxLayout.setHorizontalGroup(painelComboBoxLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelComboBoxLayout.createSequentialGroup().addGap(19, 19, 19)
                        .addGroup(painelComboBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboBoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTamanho)
                                .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelGenero))
                        .addContainerGap(17, Short.MAX_VALUE)));
        painelComboBoxLayout.setVerticalGroup(painelComboBoxLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelComboBoxLayout.createSequentialGroup().addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(labelGenero).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTamanho).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(painelCadastroLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCadastroLayout.createSequentialGroup().addContainerGap().addGroup(painelCadastroLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelCadastroLayout.createSequentialGroup().addGroup(painelCadastroLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(scroll)
                                .addGroup(painelCadastroLayout.createSequentialGroup().addGroup(painelCadastroLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroLayout
                                                .createSequentialGroup()
                                                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(170, 170, 170).addComponent(botaoAlterar,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(labelPesquisa, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroLayout
                                                .createSequentialGroup()
                                                .addGroup(painelCadastroLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelMarca).addComponent(textoMarca,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(painelCadastroLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(textoModelo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelModelo))
                                                .addGroup(painelCadastroLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(painelCadastroLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18).addComponent(textoCor,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(painelCadastroLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17).addComponent(labelCor)))
                                                .addGap(18, 18, 18)
                                                .addGroup(painelCadastroLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(textoQuantidade,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelQuantidade))
                                                .addGap(18, 18, 18)
                                                .addGroup(painelCadastroLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelPreco).addComponent(textoPreco,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroLayout
                                                .createSequentialGroup()
                                                .addComponent(textoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(painelCadastroLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(painelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(89, 89, 89))
                        .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)))));
        painelCadastroLayout.setVerticalGroup(painelCadastroLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCadastroLayout.createSequentialGroup().addGroup(painelCadastroLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelCadastroLayout.createSequentialGroup().addGap(15, 15, 15)
                                .addGroup(painelCadastroLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMarca).addComponent(labelModelo).addComponent(labelCor)
                                        .addComponent(labelQuantidade).addComponent(labelPreco))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelCadastroLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textoMarca, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoModelo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoPreco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18).addComponent(labelPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelCadastroLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoPesquisar))
                                .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroLayout
                                .createSequentialGroup().addContainerGap()
                                .addComponent(painelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoExcluir).addComponent(botaoAlterar).addComponent(botaoNovo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoCancelar).addComponent(botaoCadastrar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup().addComponent(painelCadastro,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        painelLayout.setVerticalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(painelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        pack();
    }

    private void botaoExcluirActionPerformed(ActionEvent evt) {
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        int codigoProdutoSelecionada = (int) tabelaProdutos.getValueAt(linhaSelecionada, 0);

        if (controleProdutos.excluirProdutosControle(codigoProdutoSelecionada)) {
            JOptionPane.showMessageDialog(this, "Produto Excluido");
            this.carregarProdutos();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Excluir Produto");
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
        DefaultTableModel model = (DefaultTableModel) this.tabelaProdutos.getModel();
        final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
        this.tabelaProdutos.setRowSorter(rowSorter);
        String entrada = textoPesquisa.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter(entrada, 1));
    }

    private void botaoAlterarActionPerformed(ActionEvent evt) {
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        int codigoProdutoSelecionada = (int) tabelaProdutos.getValueAt(linhaSelecionada, 0);

        try {
            modeloProduto = controleProdutos.retornarProdutoControle(codigoProdutoSelecionada);
            onOffCampos(true);

            this.textoPreco.setText(String.valueOf(modeloProduto.getPrecoProduto()));
            this.textoQuantidade.setText(String.valueOf(modeloProduto.getQtdEstoque()));
            this.textoMarca.setText(modeloProduto.getMarca());
            this.textoModelo.setText(modeloProduto.getModelo());
            this.textoCor.setText(modeloProduto.getCor());
            this.comboBoxGenero.setSelectedItem((Object) modeloProduto.getGenero());
            this.comboBoxTamanho.setSelectedItem((Object) modeloProduto.getTamanho());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código invalido ou nenhum selecionado", "Aviso",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void botaoCadastroActionPerformed(ActionEvent evt) {
        modeloProduto.setQtdEstoque(Integer.parseInt(this.textoQuantidade.getText()));
        modeloProduto.setPrecoProduto(Float.parseFloat(this.textoQuantidade.getText()));
        modeloProduto.setMarca(this.textoMarca.getText());
        modeloProduto.setModelo(this.textoModelo.getText());
        modeloProduto.setCor(this.textoCor.getText());
        modeloProduto.setTamanho(comboBoxTamanho.getSelectedItem().toString());
        modeloProduto.setGenero(comboBoxGenero.getSelectedItem().toString());

        System.out.println(
                "\n\ntamanho -> " + modeloProduto.getTamanho() + " Genero -> " + modeloProduto.getGenero() + "\n\n");

        if (controleProdutos.salvarProdutosControle(modeloProduto)) {
            JOptionPane.showMessageDialog(this, "Produto cadastrado com Sucesso");
            this.carregarProdutos();
            this.onOffCampos(false);
            this.limpaTexto();
        } else {
            JOptionPane.showMessageDialog(this, "Erro no Cadastro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewCadastroProduto().setVisible(true);
            }
        });
    }
}
