package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Serializable {
    private int numero;
    private double saldo;
    private double limite;  // Adicionando o limite da conta
    private String tipoConta;
    private String nome; // Nome do titular da conta
    private String cpf;  // CPF do titular da conta
    private List<String> extrato;  // Lista para armazenar transações

    public Conta(int numero, String tipoConta, String nome, String cpf) {
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = 0.0;
        this.limite = 0.0; // Inicializando limite
        this.nome = nome;
        this.cpf = cpf;
        this.extrato = new ArrayList<>();  // Inicializa a lista de extrato
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite; // Método para obter o limite
    }

    public void setLimite(double limite) {
        this.limite = limite; // Método para definir o limite
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito: R$ " + valor);  // Adiciona transação ao extrato
    }

    public boolean sacar(double valor) {
        if (valor <= saldo + limite) {  // Permitir saque até o saldo + limite
            saldo -= valor;
            extrato.add("Saque: R$ " + valor);  // Adiciona transação ao extrato
            return true;
        }
        return false; // Retorna false se não houver saldo suficiente
    }

    public List<String> getExtrato() {
        return extrato;  // Retorna o extrato
    }

    public abstract String consultarDetalhes(); // Método abstrato para detalhes específicos da conta
}