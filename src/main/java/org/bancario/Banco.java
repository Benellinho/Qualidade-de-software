package org.bancario;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public Conta abrirConta(String nome) {
        Conta conta = new Conta(nome);
        contas.add(conta);
        return conta;
    }

    public Conta buscarConta(int id) {
        for (Conta c : contas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public int getTotalContas() {
        return contas.size();
    }

    public void transferir(int origemId, int destinoId, double valor) {
        Conta origem = buscarConta(origemId);
        if (origem == null) {
            throw new IllegalArgumentException("Conta de origem Inexistente");
        }
        Conta destino = buscarConta(destinoId);
        if (destino == null) {
            throw new IllegalArgumentException("Conta de destino Inexistente");
        }
        origem.sacar(valor);
        destino.depositar(valor);
    }
}