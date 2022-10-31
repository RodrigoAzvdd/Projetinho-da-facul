package TP_Banco;

import java.util.Scanner;
public class AppBanco extends Relatorio{
    Scanner scan = new Scanner(System.in);
    Banco banco = new Banco();
    Relatorio relatorio = new Relatorio();
    public void menu() {
        int opt = 0;
        int escolha = 0;
        while(escolha != 5) {
            System.out.println("\n1-Criar conta\n2-Selecionar conta\n3-Remover conta\n4-Gerar relatorio\n5-Finalizar");
            escolha = scan.nextInt();
            switch (escolha) {
                case 1 -> {
                    System.out.println("1-Conta poupanca\n2-Conta corrente");
                    int conta = scan.nextInt();
                    if (conta == 1) {
                        System.out.println("Numero da conta:");
                        int numeroConta = scan.nextInt();
                        System.out.println("Saldo da conta");
                        double saldo = scan.nextDouble();
                        banco.inserir(new ContaPoupanca(numeroConta, saldo));
                    } else if (conta == 2) {
                        System.out.println("Numero da conta:");
                        int numeroConta = scan.nextInt();
                        System.out.println("Saldo da conta");
                        double saldo = scan.nextDouble();
                        banco.inserir(new ContaCorrente(numeroConta, saldo));
                    }
                }
                case 2 -> {
                    System.out.println("Informe o numero da conta:");
                    int numeroConta = scan.nextInt();
                    int arrSize = banco.contaBancarias.size();
                    for (ContaBancaria conta: banco.contaBancarias) {
                        if (numeroConta == conta.numeroConta) {
                            while(opt != 5) {

                                System.out.println("\nO que deseja fazer? ");
                                System.out.println("1 - SACAR");
                                System.out.println("2 - DEPOSITAR");
                                System.out.println("3 - RELATORIO");
                                System.out.println("4 - TRANSFERIR");
                                System.out.println("5 - VOLTAR");

                                int opcao = scan.nextInt();

                                switch (opcao) {
                                    case 1 -> {
                                        System.out.println("Quanto deseja sacar? ");
                                        double saque = scan.nextInt();
                                        conta.sacar(saque);
                                    }
                                    case 2 -> {
                                        System.out.println("Quanto deseja depositar? ");
                                        double deposito = scan.nextInt();
                                        conta.depositar(deposito);
                                    }
                                    case 3 -> {
                                        relatorio.gerarRelatorio((Imprimivel) conta);
                                    }
                                    case 4 -> {
                                        System.out.println("Informe o numero da conta que deseja tranferir o dinheiro: ");
                                        int contaTrans = scan.nextInt();
                                        System.out.println("Informe quanto deseja transferir da sua conta poupança para a corrente: ");
                                        double transferencia = scan.nextDouble();
                                        for (ContaBancaria contaT: banco.contaBancarias) {
                                            if (contaTrans == contaT.numeroConta) {
                                                conta.transferir(transferencia, contaT);
                                            }
                                        }
                                    }
                                    case 5 -> opt = 5;
                                }
                            }
                        } else if (banco.contaBancarias.size() == arrSize && conta == banco.contaBancarias.get(banco.contaBancarias.size() - 1) || banco.contaBancarias.get(0) == null) {
                            System.out.println("Conta inexistente!");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Informe o numero da conta:");
                    int numConta = scan.nextInt();
                    int arrSize = banco.contaBancarias.size();
                    for (ContaBancaria conta: banco.contaBancarias) {
                        if (numConta == conta.numeroConta) {
                            banco.remover(conta);
                            System.out.println("Conta removida!");
                            break;
                        } else if (banco.contaBancarias.size() == arrSize && conta == banco.contaBancarias.get(banco.contaBancarias.size() - 1)) {
                            System.out.println("Conta inexistente!");
                        }
                    }
                }
                case 4 -> {
                    for (ContaBancaria conta: banco.contaBancarias) {
                        System.out.println(conta);
                    }
                }
            }
        }
    }
}
