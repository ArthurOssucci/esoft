class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}