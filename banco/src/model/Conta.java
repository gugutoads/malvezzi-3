package model;

import java.io.Serializable;

public abstract class Conta implements Serializable {
    private int numero;
    private double saldo;
    private String tipoConta;
    private String nome; // Nome do titular da conta
    private String cpf;  // CPF do titular da conta

    public Conta(int numero, String tipoConta, String nome, String cpf) {
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = 0.0;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
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

    // Métodos para alterar o nome e o CPF
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public abstract String consultarDetalhes();
}
