import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Entrada do usuário
            System.out.print("Digite o endereço (ex: www.google.com.br): ");
            String endereco = sc.nextLine();

            System.out.print("Digite a porta (ex: 80): ");
            int porta = sc.nextInt();

            // Criando conexão com o servidor
            Socket sock = new Socket(endereco, porta);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            // Envia requisição GET simples
            out.println("GET / HTTP/1.0\n");

            // Lê a resposta do servidor
            String linha;
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }

            // Fecha recursos
            in.close();
            out.close();
            sock.close();
        } catch (IOException e) {
            System.err.println("Problemas de IO: " + e.getMessage());
        }
    }
}
// Programa que concecta a um servidor web em uma porta especificada pelo usuário.