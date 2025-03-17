interface MetodoPagamento {
    void processarPagamento(double valor);
}

class PagamentoPix implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento realizado via Pix no valor de R$" + valor);
    }
}

class PagamentoCartaoCredito implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento aprovado no cartão de crédito no valor de R$" + valor);
    }
}

class PagamentoBoleto implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Boleto gerado no valor de R$" + valor);
    }
}

class FabricaPagamento {
    public static MetodoPagamento criarMetodoPagamento(String tipo) {
        switch (tipo.toLowerCase()) {
            case "pix":
                return new PagamentoPix();
            case "cartao":
                return new PagamentoCartaoCredito();
            case "boleto":
                return new PagamentoBoleto();
            default:
                throw new IllegalArgumentException("Tipo de pagamento desconhecido.");
        }
    }
}

class ProcessadorPagamento {
    private MetodoPagamento metodoPagamento;
    
    public ProcessadorPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    public void executarPagamento(double valor) {
        metodoPagamento.processarPagamento(valor);
    }
}

import java.util.Scanner;
public class AplicacaoPagamento {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        System.out.print("Opção: ");
        
        int opcao = entrada.nextInt();
        entrada.nextLine();
        
        System.out.print("Digite o valor da transação: ");
        double valor = entrada.nextDouble();
        
        MetodoPagamento metodo = null;
        
        switch (opcao) {
            case 1:
                metodo = FabricaPagamento.criarMetodoPagamento("pix");
                break;
            case 2:
                metodo = FabricaPagamento.criarMetodoPagamento("cartao");
                break;
            case 3:
                metodo = FabricaPagamento.criarMetodoPagamento("boleto");
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        ProcessadorPagamento processador = new ProcessadorPagamento(metodo);
        processador.executarPagamento(valor);
    }
}
