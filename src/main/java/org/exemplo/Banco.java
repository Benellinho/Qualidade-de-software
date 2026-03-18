package org.exemplo;

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
        Conta destino = buscarConta(destinoId);

        origem.sacar(valor);
        destino.depositar(valor);
    }
}