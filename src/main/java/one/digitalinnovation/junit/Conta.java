package one.digitalinnovation.junit;

public class Conta {

    private String numeroConta;
    private double saldo;

    public Conta(String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void lancaCredito(double valor){
        saldo += valor;
    }

    public void lancaDebito(double valor){
        saldo -= valor;
    }
}
