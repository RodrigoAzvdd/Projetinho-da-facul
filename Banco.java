package TP_Banco;

import java.util.ArrayList;

public class Banco implements Imprimivel{
    ArrayList<ContaBancaria> contaBancarias = new ArrayList<>();

    public void inserir(ContaBancaria contaBancaria) {
        contaBancarias.add(contaBancaria);
    }

    public void remover(ContaBancaria contaBancaria) {
        contaBancarias.remove(contaBancaria);
    }

    public void pocurarConta(int i) {
        System.out.println(contaBancarias.get(i));
    }

    @Override
    public void mostrarDados() {
        for (ContaBancaria conta: contaBancarias) {
            System.out.println(conta);
        }
    }
}