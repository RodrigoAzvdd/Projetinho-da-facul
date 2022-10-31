package TP_Banco;

public class ContaCorrente extends ContaBancaria implements Imprimivel {

    private double taxadeOperacao = 100;

    public ContaCorrente(int numeroConta, double saldo) {
        super(numeroConta,saldo);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void transferir(double transferencia, ContaBancaria contaBancaria) {
        saldo -= transferencia;
        contaBancaria.saldo += transferencia;
    }
    @Override
    public void sacar(double saque) {
        saldo -=  (saque + taxadeOperacao);
    }

    @Override
    public void depositar(double deposito) {
        saldo += deposito - taxadeOperacao;
    }

    public double getTaxadeOperacao() {
        return taxadeOperacao;
    }

    public void setTaxadeOperacao(double taxadeOperacao) {
        this.taxadeOperacao = taxadeOperacao;
    }

    @Override
    public void mostrarDados() {
        System.out.printf("\nNúmero da conta: %d, Saldo da conta: %.2f.", numeroConta, saldo);
    }
}
