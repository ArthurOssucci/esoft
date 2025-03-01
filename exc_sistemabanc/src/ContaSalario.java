class ContaSalario extends ContaCorrente {
    private int saquesGratuitos;

    public ContaSalario(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
        this.saquesGratuitos = 1;
    }

    public boolean sacar(double valor) {
        if (saquesGratuitos > 0) {
            saquesGratuitos--;
            return super.sacar(valor);
        } else if (saldo >= (valor + 5)) {
            saldo -= (valor + 5);
            return true;
        }
        return false;
    }
}