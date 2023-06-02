package Entidades;

public class ContaBancaria {
    private String nome;
    private int num_conta;
    private double saldo;

    public ContaBancaria(String nome, int num_conta, double saldo) {
        this.nome = nome;
        this.num_conta = num_conta;
        this.saldo = saldo;

    }

    // SETS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // GETS
    public String getNome() {
        return this.nome;
    }

    public int getNum_conta() {
        return this.num_conta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // METODOS
    public void sacar(double valor) {

        if (this.saldo - valor >= 0) {
            this.saldo -= valor;
            System.out.printf("\nO valor de R$%.2f foi sacado, o novo saldo é R$%.2f", valor, this.saldo);

        } else {
            System.out.println("Não existe saldo disponível!");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("\nO valor de R$%.2f foi depositado,", valor);
    }

    public int deletar() {
        if (this.saldo == 0) {
            System.out.println("Conta Encerrada!");
            return 1;
        } else {
            if (saldo < 0) {
                System.out.println("Não é possível encerrar a conta! Existe saldo negativo");

            } else {
                System.out.println("Não é possível encerrar a conta! Ainda existe saldo");

            }
        }
        return 0;
    }
}
