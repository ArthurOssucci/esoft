import entities.User;
import repository.UserRepository;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlite:database.db";
        try (Connection connection = DriverManager.getConnection(dbUrl)) {
            UserRepository userRepository = new UserRepository(connection);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Cadastrar usuário");
                System.out.println("2. Listar usuários");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Senha: ");
                        String password = scanner.nextLine();
                        User newUser = new User(UUID.randomUUID(), name, email, password);
                        userRepository.save(newUser);
                        System.out.println("Usuário cadastrado com sucesso!");
                        break;

                    case 2:
                        List<User> users = userRepository.findAll();
                        users.forEach(u -> System.out.println(
                                "UUID: " + u.getUuid() +
                                ", Nome: " + u.getName() +
                                ", Email: " + u.getEmail()));
                        break;

                    case 3:
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }
}
