package org.bancario;

public class Conta {
    private static int SEQUENCIAL = 1;
    private double saldo;
    public String nome;
    private int id;

    public Conta(String nome) {
        this.nome = nome;
        this.saldo = 0;
        this.id = SEQUENCIAL++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= valor;
    }

}
