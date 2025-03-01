class ContaInvestimento extends ContaBancaria {
    public ContaInvestimento(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    public boolean sacar(double valor) {
        double taxa = valor * 0.02;
        if (saldo >= (valor + taxa)) {
            saldo -= (valor + taxa);
            return true;
        }
        return false;
    }
}