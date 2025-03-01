class ContaInvestimentoAltoRisco extends ContaInvestimento {
    public ContaInvestimentoAltoRisco(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    public boolean sacar(double valor) {
        double taxa = valor * 0.05;
        if (saldo >= (valor + taxa) && saldo - (valor + taxa) >= 10000) {
            saldo -= (valor + taxa);
            return true;
        }
        return false;
    }
}