package Entidades;

public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String nome, int num_conta, double saldo, double limite) {
        super(nome, num_conta, saldo);
        this.limite = limite;

    }

    // SET
    public void setLimite(double limite) {
        this.limite = limite;
    }

    // GET
    public double getLimite() {
        return this.limite;
    }

    @Override
    public void depositar(double valor) {
        if (this.getSaldo() < 0) {
            this.setLimite(getLimite() + valor - (getSaldo() + valor));
            this.setSaldo(this.getSaldo() + valor);
            System.out.printf("\nO valor de R$%.2f foi depositado, o limite foi restaurado para R$%.2f", valor,
                    this.getLimite());
        } else {

            this.setSaldo(this.getSaldo() + valor);
            System.out.printf("\nO valor de R$%.2f foi depositado,", valor);
        }

    }

    @Override
    public void sacar(double valor) {
        if (this.getSaldo() - valor >= 0) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.printf("\nO valor de R$%.2f foi sacado, o novo saldo é %.2f", valor, this.getSaldo());

        } else if ((this.getSaldo() + this.limite) - valor >= 0) {
            this.limite -= getSaldo() > 0 ? valor - this.getSaldo() : valor;
            this.setSaldo(this.getSaldo() - valor);
            System.out.printf("\nO valor de R$%.2f foi sacado, o novo saldo é %.2f e resta %.2f de limite", valor,
                    this.getSaldo(), this.limite);

        } else {
            System.out.println("\nNão existe saldo nem limite disponível!");
        }

    }
}
