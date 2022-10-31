package TP_Banco;

public abstract class ContaBancaria {

    public int numeroConta = 0;
    public double saldo = 0;

    public ContaBancaria(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "" +
                "\nNumero da conta: " + numeroConta +
                "\nSaldo da conta: " + saldo;
    }

    public abstract void transferir(double transferencia, ContaBancaria contaBancaria);
    public abstract void sacar(double saque);
    public abstract void depositar(double deposito);
}
