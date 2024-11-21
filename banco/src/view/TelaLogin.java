package view;

import controller.BancoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Banco Malvader - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(3, 1));

        JTextField txtUsuario = new JTextField();
        JPasswordField txtSenha = new JPasswordField();

        add(new JLabel("Usuário:"));
        add(txtUsuario);
        add(new JLabel("Senha:"));
        add(txtSenha);

        JButton btnCliente = new JButton("Cliente");
        JButton btnFuncionario = new JButton("Funcionário");

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(btnCliente);
        panelButtons.add(btnFuncionario);
        add(panelButtons);

        // Evento do botão Cliente
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuCliente(); // Redireciona para o menu do cliente
                dispose(); // Fecha a tela de login
            }
        });

        // Evento do botão Funcionário
        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BancoController bancoController = new BancoController(); // Cria o controlador
                    new MenuFuncionario(bancoController); // Passa o controlador para o MenuFuncionario
                    dispose(); // Fecha a tela de login
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao iniciar o menu do Funcionário: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true); // Torna a janela visível
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
