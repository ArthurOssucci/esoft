interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando Push Notification: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Tipo de notificação inválido.");
        }
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");
        System.out.print("Opção: ");
        
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        
        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();
        
        Notification notificacao = null;
        
        switch (escolha) {
            case 1:
                notificacao = NotificationFactory.createNotification("email");
                break;
            case 2:
                notificacao = NotificationFactory.createNotification("sms");
                break;
            case 3:
                notificacao = NotificationFactory.createNotification("push");
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        notificacao.send(mensagem);
    }
}
