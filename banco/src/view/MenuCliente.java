package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCliente extends JFrame {
    public MenuCliente() {
        setTitle("Banco Malvader - Menu Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton saldoButton = new JButton("Saldo");
        saldoButton.setBounds(50, 30, 120, 30);
        saldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação de ver saldo
                JOptionPane.showMessageDialog(null, "Função de Saldo ainda não implementada.");
            }
        });
        panel.add(saldoButton);

        JButton depositoButton = new JButton("Depósito");
        depositoButton.setBounds(200, 30, 120, 30);
        depositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação de depósito
                JOptionPane.showMessageDialog(null, "Função de Depósito ainda não implementada.");
            }
        });
        panel.add(depositoButton);

        JButton saqueButton = new JButton("Saque");
        saqueButton.setBounds(50, 80, 120, 30);
        saqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação de saque
                JOptionPane.showMessageDialog(null, "Função de Saque ainda não implementada.");
            }
        });
        panel.add(saqueButton);

        JButton extratoButton = new JButton("Extrato");
        extratoButton.setBounds(200, 80, 120, 30);
        extratoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação de extrato
                JOptionPane.showMessageDialog(null, "Função de Extrato ainda não implementada.");
            }
        });
        panel.add(extratoButton);

        JButton limiteButton = new JButton("Consultar Limite");
        limiteButton.setBounds(50, 130, 120, 30);
        limiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação de consultar limite
                JOptionPane.showMessageDialog(null, "Função de Consultar Limite ainda não implementada.");
            }
        });
        panel.add(limiteButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setBounds(200, 130, 120, 30);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin(); // Retorna à tela de login
                dispose();
            }
        });
        panel.add(sairButton);

        add(panel);
        setVisible(true);
    }
}
