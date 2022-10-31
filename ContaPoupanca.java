package TP_Banco;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {

    private double limite = 100;

    public ContaPoupanca(int numeroConta, double saldo) {
        super(numeroConta, saldo);
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

        double limitCheck = (saldo - saque)*-1;
        if (limitCheck <= limite) {
            saldo -= saque;
        }
        else {
            System.out.println("Limite excedido.");
        }

    }

    @Override
    public void depositar(double deposito) {
        saldo += deposito;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void mostrarDados() {
        System.out.printf("\nNúmero da conta: %d, Saldo da conta: %.2f.", numeroConta, saldo);
    }
}
