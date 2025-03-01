public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("12345", "João", 2000, 500);
        ContaPoupanca cp = new ContaPoupanca("54321", "Maria", 3000);
        ContaInvestimento ci = new ContaInvestimento("67890", "Carlos", 5000);
        ContaSalario cs = new ContaSalario("13579", "Ana", 1500, 0);
        ContaInvestimentoAltoRisco cial = new ContaInvestimentoAltoRisco("98765", "Pedro", 15000);

        cc.exibirInformacoes();
        System.out.println("Saque de R$ 2200: " + cc.sacar(2200));
        cc.exibirInformacoes();

        System.out.println();

        cp.exibirInformacoes();
        System.out.println("Saque de R$ 3500: " + cp.sacar(3500));
        cp.exibirInformacoes();

        System.out.println();

        ci.exibirInformacoes();
        System.out.println("Saque de R$ 1000: " + ci.sacar(1000));
        ci.exibirInformacoes();

        System.out.println();

        cs.exibirInformacoes();
        System.out.println("Saque de R$ 500: " + cs.sacar(500));
        System.out.println("Saque de R$ 500 com taxa: " + cs.sacar(500));
        cs.exibirInformacoes();

        System.out.println();

        cial.exibirInformacoes();
        System.out.println("Saque de R$ 5000: " + cial.sacar(5000));
        cial.exibirInformacoes();
    }
}