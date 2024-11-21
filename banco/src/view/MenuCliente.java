package view;

import model.Conta; // Certifique-se de que esta classe existe e está no pacote correto
import utils.DataManager; // Certifique-se de que esta classe existe e está no pacote correto
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuCliente extends JFrame {

    public MenuCliente() {
        setTitle("Banco Malvader - Menu Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // Melhor organização dos botões

        // Botões e ações
        JButton saldoButton = new JButton("Saldo");
        saldoButton.addActionListener(e -> consultarSaldo());
        panel.add(saldoButton);

        JButton depositoButton = new JButton("Depósito");
        depositoButton.addActionListener(e -> realizarDeposito());
        panel.add(depositoButton);

        JButton saqueButton = new JButton("Saque");
        saqueButton.addActionListener(e -> realizarSaque());
        panel.add(saqueButton);

        JButton extratoButton = new JButton("Extrato");
        extratoButton.addActionListener(e -> consultarExtrato());
        panel.add(extratoButton);

        JButton limiteButton = new JButton("Consultar Limite");
        limiteButton.addActionListener(e -> consultarLimite());
        panel.add(limiteButton);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> dispose());
        panel.add(sairButton);

        // Adiciona o painel ao JFrame
        add(panel);
        setVisible(true);
    }

    private void consultarSaldo() {
        JFrame frame = new JFrame("Consultar Saldo");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        JTextField tfNumeroConta = new JTextField(15);
        JButton btnConsultar = new JButton("Consultar");

        panel.add(labelNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(btnConsultar);

        frame.add(panel);
        frame.setVisible(true);

        btnConsultar.addActionListener(e -> {
            String numeroConta = tfNumeroConta.getText().trim();

            if (numeroConta.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "O número da conta deve ser preenchido.");
                return;
            }

            try {
                List<Conta> contas = DataManager.carregarContas("contas.dat");
                Conta conta = contas.stream()
                        .filter(c -> String.valueOf(c.getNumero()).equals(numeroConta))
                        .findFirst()
                        .orElse(null);

                if (conta == null) {
                    JOptionPane.showMessageDialog(frame, "Conta não encontrada.");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Número da Conta: " + conta.getNumero() + "\n" +
                                    "Saldo: " + conta.getSaldo());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao consultar a conta: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    private void realizarDeposito() {
        JFrame frame = new JFrame("Realizar Depósito");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        JTextField tfNumeroConta = new JTextField(15);
        JLabel labelValorDeposito = new JLabel("Valor do Depósito:");
        JTextField tfValorDeposito = new JTextField(15);
        JButton btnDepositar = new JButton("Depositar");

        panel.add(labelNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(labelValorDeposito);
        panel.add(tfValorDeposito);
        panel.add(btnDepositar);

        frame.add(panel);
        frame.setVisible(true);

        btnDepositar.addActionListener(e -> {
            String numeroContaStr = tfNumeroConta.getText().trim();
            String valorDepositoStr = tfValorDeposito.getText().trim();

            if (numeroContaStr.isEmpty() || valorDepositoStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.");
                return;
            }

            try {
                int numeroConta = Integer.parseInt(numeroContaStr);
                double valorDeposito = Double.parseDouble(valorDepositoStr);

                if (valorDeposito <= 0) {
                    JOptionPane.showMessageDialog(frame, "O valor do depósito deve ser positivo.");
                    return;
                }

                List<Conta> contas = DataManager.carregarContas("contas.dat");
                Conta conta = contas.stream()
                        .filter(c -> c.getNumero() == numeroConta)
                        .findFirst()
                        .orElse(null);

                if (conta == null) {
                    JOptionPane.showMessageDialog(frame, "Conta não encontrada.");
                } else {
                    conta.depositar(valorDeposito);
                    DataManager.salvarContas(contas, "contas.dat");
                    JOptionPane.showMessageDialog(frame, "Depósito realizado com sucesso!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Número da conta e valor do depósito devem ser válidos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao realizar o depósito: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    private void realizarSaque() {
        JFrame frame = new JFrame("Realizar Saque");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        JTextField tfNumeroConta = new JTextField(15);
        JLabel labelValorSaque = new JLabel("Valor do Saque:");
        JTextField tfValorSaque = new JTextField(15);
        JButton btnSacar = new JButton("Sacar");

        panel.add(labelNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(labelValorSaque);
        panel.add(tfValorSaque);
        panel.add(btnSacar);

        frame.add(panel);
        frame.setVisible(true);

        btnSacar.addActionListener(e -> {
            String numeroContaStr = tfNumeroConta.getText().trim();
            String valorSaqueStr = tfValorSaque.getText().trim();

            if (numeroContaStr.isEmpty() || valorSaqueStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.");
                return;
            }

            try {
                int numeroConta = Integer.parseInt(numeroContaStr);
                double valorSaque = Double.parseDouble(valorSaqueStr);

                if (valorSaque <= 0) {
                    JOptionPane.showMessageDialog(frame, "O valor do saque deve ser positivo.");
                    return;
                }

                List<Conta> contas = DataManager.carregarContas("contas.dat");
                Conta conta = contas.stream()
                        .filter(c -> c.getNumero() == numeroConta)
                        .findFirst()
                        .orElse(null);

                if (conta == null) {
                    JOptionPane.showMessageDialog(frame, "Conta não encontrada.");
                } else if (conta.getSaldo() < valorSaque) {
                    JOptionPane.showMessageDialog(frame, "Saldo insuficiente para saque.");
                } else {
                    conta.sacar(valorSaque);
                    DataManager.salvarContas(contas, "contas.dat");
                    JOptionPane.showMessageDialog(frame, "Saque realizado com sucesso!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Número da conta e valor do saque devem ser válidos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao realizar o saque: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    private void consultarExtrato() {
        JFrame frame = new JFrame("Consultar Extrato");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        JTextField tfNumeroConta = new JTextField(15);
        JButton btnConsultar = new JButton("Consultar");

        panel.add(labelNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(btnConsultar);

        frame.add(panel);
        frame.setVisible(true);

        btnConsultar.addActionListener(e -> {
            String numeroConta = tfNumeroConta.getText().trim();

            if (numeroConta.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "O número da conta deve ser preenchido.");
                return;
            }

            try {
                List<Conta> contas = DataManager.carregarContas("contas.dat");
                Conta conta = contas.stream()
                        .filter(c -> String.valueOf(c.getNumero()).equals(numeroConta))
                        .findFirst()
                        .orElse(null);

                if (conta == null) {
                    JOptionPane.showMessageDialog(frame, "Conta não encontrada.");
                } else {
                    StringBuilder extrato = new StringBuilder("Extrato da Conta " + conta.getNumero() + ":\n\n");
                    List<String> transacoes = conta.getExtrato(); // Certifique-se de que `Conta` possui um método `getExtrato`

                    if (transacoes.isEmpty()) {
                        extrato.append("Nenhuma transação encontrada.");
                    } else {
                        for (String transacao : transacoes) {
                            extrato.append(transacao).append("\n");
                        }
                    }

                    JOptionPane.showMessageDialog(frame, extrato.toString());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao consultar o extrato: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
    
    
    private void consultarLimite() {
        JFrame frame = new JFrame("Consultar Limite");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        JTextField tfNumeroConta = new JTextField(15);
        JButton btnConsultar = new JButton("Consultar");

        panel.add(labelNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(btnConsultar);

        frame.add(panel);
        frame.setVisible(true);

        btnConsultar.addActionListener(e -> {
            String numeroConta = tfNumeroConta.getText().trim();

            if (numeroConta.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "O número da conta deve ser preenchido.");
                return;
            }

            try {
                List<Conta> contas = DataManager.carregarContas("contas.dat");
                Conta conta = contas.stream()
                        .filter(c -> String.valueOf(c.getNumero()).equals(numeroConta))
                        .findFirst()
                        .orElse(null);

                if (conta == null) {
                    JOptionPane.showMessageDialog(frame, "Conta não encontrada.");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Número da Conta: " + conta.getNumero() + "\n" +
                                    "Limite: " + conta.getLimite());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao consultar o limite: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new MenuCliente();
    }
}
