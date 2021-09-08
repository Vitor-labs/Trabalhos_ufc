package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewTelaPrincipal extends javax.swing.JFrame {

        // Variables declaration - do not modify
        private JButton botaoCadastroProduto;
        private JButton botaoCadastroFornecedor;
        private JLabel labelCadastro;
        private JLabel labelCadastroProduto;
        private JLabel labelCadastroFornecedor;
        private JPanel painel;
        // End of variables declaration

        public viewTelaPrincipal() {
                initComponents();
        }

        private void initComponents() {

                painel = new JPanel();
                botaoCadastroProduto = new JButton();
                botaoCadastroFornecedor = new JButton();
                labelCadastro = new JLabel();
                labelCadastroProduto = new JLabel();
                labelCadastroFornecedor = new JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Estoques V&Bs.");

                painel.setBackground(new Color(51, 51, 51));
                painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                painel.setForeground(new Color(60, 63, 65));

                botaoCadastroProduto.setText("Cadastrar");
                botaoCadastroProduto.setBackground(Color.darkGray);
                botaoCadastroProduto.setForeground(Color.LIGHT_GRAY);
                botaoCadastroProduto.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                botaoCadastroProdutoActionPerformed(evt);
                        }
                });

                botaoCadastroFornecedor.setText("Cadastrar");
                botaoCadastroFornecedor.setBackground(Color.darkGray);
                botaoCadastroFornecedor.setForeground(Color.LIGHT_GRAY);
                botaoCadastroFornecedor.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                botaoCadastroFornecedorActionPerformed(evt);
                        }
                });

                labelCadastro.setText("Cadastros");
                labelCadastro.setBackground(new Color(51, 51, 51));
                labelCadastro.setForeground(Color.LIGHT_GRAY);
                labelCadastro.setOpaque(true);

                labelCadastroProduto.setText("Novo Produto");
                labelCadastroProduto.setBackground(new Color(51, 51, 51));
                labelCadastroProduto.setForeground(Color.LIGHT_GRAY);
                labelCadastroProduto.setOpaque(true);

                labelCadastroFornecedor.setText("Novo Fornecedor");
                labelCadastroFornecedor.setBackground(new Color(51, 51, 51));
                labelCadastroFornecedor.setForeground(Color.LIGHT_GRAY);
                labelCadastroFornecedor.setOpaque(true);

                javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
                painel.setLayout(painelLayout);
                painelLayout.setHorizontalGroup(painelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout
                                                .createSequentialGroup()
                                                .addGroup(painelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(painelLayout.createSequentialGroup().addGap(
                                                                                14, 14, 14).addComponent(
                                                                                                labelCadastroProduto))
                                                                .addGroup(painelLayout.createSequentialGroup().addGap(
                                                                                15, 15, 15)
                                                                                .addComponent(labelCadastroFornecedor)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51,
                                                                Short.MAX_VALUE)
                                                .addGroup(painelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(botaoCadastroProduto,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                67, Short.MAX_VALUE)
                                                                .addComponent(botaoCadastroFornecedor,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(16, 16, 16))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout
                                                .createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(labelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 68,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82)));
                painelLayout.setVerticalGroup(painelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(labelCadastro).addGap(16, 16, 16)
                                                .addGroup(painelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(labelCadastroProduto)
                                                                .addComponent(botaoCadastroProduto,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                23,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27,
                                                                Short.MAX_VALUE)
                                                .addGroup(painelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(labelCadastroFornecedor)
                                                                .addComponent(botaoCadastroFornecedor,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(16, 16, 16)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }

        private void botaoCadastroProdutoActionPerformed(ActionEvent evt) {
                new viewCadastroProduto().setVisible(true);
                // viewTelaPrincipal().setVisible(false);

        }

        private void botaoCadastroFornecedorActionPerformed(ActionEvent evt) {
                new viewCadastroFornecedor().setVisible(true);
        }

        public static void main(String args[]) {

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new viewTelaPrincipal().setVisible(true);
                        }
                });
        }
}
