package view;

import controller.BancoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Conta; // Para utilizar o modelo de Conta
import utils.DataManager; // Para carregar as contas

public class MenuFuncionario extends JFrame {
    private BancoController bancoController;

    public MenuFuncionario(BancoController bancoController) {
        this.bancoController = bancoController;

        setTitle("Menu Funcionário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JButton btnAbrirConta = new JButton("Abrir Conta");
        JButton btnEncerrarConta = new JButton("Encerrar Conta");
        JButton btnConsultarConta = new JButton("Consultar Conta");
        JButton btnAlterarDados = new JButton("Alterar Dados");
        JButton btnCadastroFuncionario = new JButton("Cadastro Funcionario");
        JButton btnGerarRelatorios = new JButton("Gerar Relatórios");
        JButton btnSair = new JButton("Sair");

        panel.add(btnAbrirConta);
        panel.add(btnEncerrarConta);
        panel.add(btnConsultarConta);
        panel.add(btnAlterarDados);
        panel.add(btnCadastroFuncionario);
        panel.add(btnGerarRelatorios);
        panel.add(btnSair);

        // Abrir Conta
        btnAbrirConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirConta();
            }
        });

        // Encerrar Conta
        btnEncerrarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarConta();
            }
        });

        // Consultar Conta
        btnConsultarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarConta();
            }
        });

        // Alterar Dados
        btnAlterarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarDados();
            }
        });

        // Cadastro Funcionario
        btnCadastroFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFuncionario();
            }
        });

        // Gerar Relatórios
        btnGerarRelatorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarRelatorios();
            }
        });

        // Sair
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha o menu de funcionário
            }
        });

        setVisible(true); // Torna a janela visível
    }

    // Métodos que serão chamados pelos botões

    public void abrirConta() {
        // Cria uma nova janela de formulário para abrir conta
        new FormularioAbrirConta();
    }

    public void encerrarConta() {
        JOptionPane.showMessageDialog(this, "Encerrar Conta");
    }

    public void consultarConta() {
        // Tela de consulta de conta
        JFrame frame = new JFrame("Consultar Conta");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        JTextField tfNumeroConta = new JTextField(15);
        JButton btnConsultar = new JButton("Consultar");

        panel.add(labelNumeroConta);
        panel.add(tfNumeroConta);
        panel.add(btnConsultar);

        // Ação do botão para consultar a conta
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroConta = tfNumeroConta.getText().trim();

                if (numeroConta.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "O número da conta deve ser preenchido.");
                    return;
                }

                try {
                    // Tentar carregar as contas do arquivo
                    List<Conta> contas = DataManager.carregarContas("contas.dat");

                    // Procurar a conta pelo número
                    boolean contaEncontrada = false;
                    for (Conta conta : contas) {
                        if (String.valueOf(conta.getNumero()).equals(numeroConta)) {
                            // Exibir os detalhes da conta, incluindo nome e CPF
                            JOptionPane.showMessageDialog(frame,
                                    "Número da Conta: " + conta.getNumero() + "\n" +
                                            "Nome: " + conta.getNome() + "\n" +
                                            "CPF: " + conta.getCpf() + "\n" +
                                            "Tipo de Conta: " + conta.getTipoConta() + "\n" +
                                            "Saldo: " + conta.getSaldo() + "\n" +
                                            conta.consultarDetalhes());
                            contaEncontrada = true;
                            break;
                        }
                    }

                    if (!contaEncontrada) {
                        JOptionPane.showMessageDialog(frame, "Conta não encontrada.");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao consultar a conta: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }


    public void alterarDados() {
        JOptionPane.showMessageDialog(this, "Alterar Dados");
    }

    public void cadastrarFuncionario() {
        JOptionPane.showMessageDialog(this, "Cadastrar Funcionario");
    }

    public void gerarRelatorios() {
        JOptionPane.showMessageDialog(this, "Gerar Relatórios");
    }
}
