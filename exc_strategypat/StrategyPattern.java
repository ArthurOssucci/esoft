interface EstrategiaPagamento {
    void processarPagamento(double valor);
}

import java.util.UUID;
class PagamentoPix implements EstrategiaPagamento {
    @Override
    public void processarPagamento(double valor) {
        String codigoPix = UUID.randomUUID().toString();
        System.out.println("Pagamento via Pix: Código gerado - " + codigoPix);
        System.out.println("Valor: R$" + valor);
    }
}

import java.util.Scanner;
class PagamentoCartaoCredito implements EstrategiaPagamento {
    @Override
    public void processarPagamento(double valor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão de crédito: ");
        String numeroCartao = scanner.nextLine();
        System.out.println("Pagamento aprovado para o cartão: " + numeroCartao);
        System.out.println("Valor: R$" + valor);
    }
}

class PagamentoBoleto implements EstrategiaPagamento {
    @Override
    public void processarPagamento(double valor) {
        String codigoBoleto = "23791.12345 12345.678901 12345.678901 1 12345678901234";
        System.out.println("Pagamento via Boleto: Código gerado - " + codigoBoleto);
        System.out.println("Valor: R$" + valor);
    }
}

class ProcessadorPagamento {
    private EstrategiaPagamento estrategia;
    
    public ProcessadorPagamento(EstrategiaPagamento estrategia) {
        this.estrategia = estrategia;
    }
    
    public void executarPagamento(double valor) {
        estrategia.processarPagamento(valor);
    }
}

import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        System.out.print("Opção: ");
        
        int opcao = scanner.nextInt();
        
        System.out.print("Digite o valor da transação: ");
        double valor = scanner.nextDouble();
        
        EstrategiaPagamento estrategia = null;
        
        switch (opcao) {
            case 1:
                estrategia = new PagamentoPix();
                break;
            case 2:
                estrategia = new PagamentoCartaoCredito();
                break;
            case 3:
                estrategia = new PagamentoBoleto();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        ProcessadorPagamento processador = new ProcessadorPagamento(estrategia);
        processador.executarPagamento(valor);
    }
}
