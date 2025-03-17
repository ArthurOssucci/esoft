interface Notificacao {
    void enviar(String mensagem);
}

class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

class NotificacaoSMS implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

class NotificacaoPush implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Push Notification: " + mensagem);
    }
}

class FabricaNotificacao {
    public static Notificacao criarNotificacao(String tipo) {
        switch (tipo.toLowerCase()) {
            case "email":
                return new NotificacaoEmail();
            case "sms":
                return new NotificacaoSMS();
            case "push":
                return new NotificacaoPush();
            default:
                throw new IllegalArgumentException("Tipo de notificação inválido.");
        }
    }
}

import java.util.Scanner;
public class AplicacaoNotificacao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");
        System.out.print("Opção: ");
        
        int opcao = entrada.nextInt();
        entrada.nextLine(); // Consumir a quebra de linha
        
        System.out.print("Digite a mensagem: ");
        String mensagem = entrada.nextLine();
        
        Notificacao notificacao = null;
        
        switch (opcao) {
            case 1:
                notificacao = FabricaNotificacao.criarNotificacao("email");
                break;
            case 2:
                notificacao = FabricaNotificacao.criarNotificacao("sms");
                break;
            case 3:
                notificacao = FabricaNotificacao.criarNotificacao("push");
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        notificacao.enviar(mensagem);
    }
}
