package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class viewLogin extends JFrame {
    // Variables declaration - do not modify
    private JButton botaoCancelar;
    private JButton botaoEntrar;
    private JLabel labelLogin;
    private JLabel labelUsuario;
    private JPanel painel;
    private JTextField textoLogin;
    private JPasswordField textoSenha;
    // End of variables declaration

    public void run() {
        new viewLogin().setVisible(true);
    }

    public viewLogin() {
        initComponents();
    }

    private void initComponents() {

        painel = new JPanel();
        labelLogin = new JLabel();
        labelUsuario = new JLabel();
        textoLogin = new JTextField();
        botaoCancelar = new JButton();
        botaoEntrar = new JButton();
        textoSenha = new JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBackground(new Color(51, 51, 51));
        painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel.setForeground(new Color(60, 63, 65));

        textoSenha.setForeground(Color.LIGHT_GRAY);
        textoSenha.setBackground(new Color(51, 51, 51));
        textoSenha.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        textoLogin.setForeground(Color.LIGHT_GRAY);
        textoLogin.setBackground(new Color(51, 51, 51));
        textoLogin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        labelLogin.setText("Login");
        labelLogin.setBackground(new Color(51, 51, 51));
        labelLogin.setForeground(Color.LIGHT_GRAY);
        labelLogin.setOpaque(true);

        labelUsuario.setText("Senha");
        labelUsuario.setBackground(new Color(51, 51, 51));
        labelUsuario.setForeground(Color.LIGHT_GRAY);
        labelUsuario.setOpaque(true);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.setBackground(Color.darkGray);
        botaoCancelar.setForeground(Color.LIGHT_GRAY);
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoEntrar.setText("Entrar");
        botaoEntrar.setBackground(Color.darkGray);
        botaoEntrar.setForeground(Color.LIGHT_GRAY);
        botaoEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup().addGap(15, 15, 15)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelLayout.createSequentialGroup().addComponent(labelLogin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoLogin))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        painelLayout.createSequentialGroup().addComponent(labelUsuario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textoSenha))
                                .addGroup(painelLayout.createSequentialGroup().addComponent(botaoCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105,
                                                Short.MAX_VALUE)
                                        .addComponent(botaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)));
        painelLayout.setVerticalGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup().addGap(12, 12, 12)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelLogin)
                                .addComponent(textoLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelUsuario)
                                .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoCancelar).addComponent(botaoEntrar))
                        .addContainerGap(13, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    private void botaoCancelarActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private boolean botaoEntrarActionPerformed(ActionEvent evt) {
        String senha = String.valueOf(textoSenha.getPassword());
        String usuario = textoLogin.getText();
        if (usuario.equals("Admin") && senha.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Bem Vindo " + usuario);
            new viewTelaPrincipal().setVisible(true);
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Usuario ou Senha Invalido");
            return false;
        }
    }
}
