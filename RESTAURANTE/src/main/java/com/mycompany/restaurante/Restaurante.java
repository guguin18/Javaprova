/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurante;

/**
 *
 * @author aluno.den
 */

import Alimentos.Pedido;
import Alimentos.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private List<Produto> cardapio;
    private List<Pedido> pedidos;   

    public Restaurante() {
        cardapio = new ArrayList<>();
        pedidos = new ArrayList<>();
        carregarCardapio();
    }

  
    private void carregarCardapio() {
        cardapio.add(new Produto("Hambúrguer", "Comida", 20.0));
        cardapio.add(new Produto("Batata Frita", "Comida", 10.0));
        cardapio.add(new Produto("Refrigerante", "Bebida", 5.0));
        cardapio.add(new Produto("Suco", "Bebida", 7.0));
    }

   
    public void exibirCardapio() {
        System.out.println("Cardápio:");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i + 1) + ". " + cardapio.get(i));
        }
        System.out.println("--------------------");
    }

    
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

 
    public void exibirPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido feito ainda.");
            return;
        }
        for (Pedido pedido : pedidos) {
            pedido.exibirPedido();
        }
    }

    
    public double calcularTotalDeTodosPedidos() {
        double totalGeral = 0;
        for (Pedido pedido : pedidos) {
            totalGeral += pedido.calcularTotal();
        }
        return totalGeral;
    }


    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);


        boolean rodando = true;
        while (rodando) {
           
            restaurante.exibirCardapio();

            
            System.out.print("Escolha o número do produto que deseja adicionar ao pedido (0 para finalizar o pedido): ");
            int opcao = scanner.nextInt();
            
            if (opcao == 0) {
                
                break;
            }

            if (opcao > 0 && opcao <= restaurante.cardapio.size()) {
                Produto produtoEscolhido = restaurante.cardapio.get(opcao - 1);

                // Perguntar quantos itens desse produto o cliente quer
                System.out.print("Quantos " + produtoEscolhido.getNome() + " deseja adicionar? ");
                int quantidade = scanner.nextInt();
                
                // Criar um novo pedido
                int pedidoId = restaurante.pedidos.size() + 1;
                Pedido pedido = new Pedido(pedidoId);
                for (int i = 0; i < quantidade; i++) {
                    pedido.adicionarProduto(produtoEscolhido);
                }
                restaurante.adicionarPedido(pedido);
                System.out.println("Produto(s) adicionado(s) ao pedido.");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

            // Perguntar se o cliente deseja fazer outro pedido
            System.out.print("Deseja adicionar outro produto ao pedido? (s/n): ");
            char continuar = scanner.next().charAt(0);
            if (continuar == 'n' || continuar == 'N') {
                rodando = false;
            }
        }

        // Exibir os pedidos realizados
        System.out.println("Pedidos realizados:");
        restaurante.exibirPedidos();

        // Exibir o total de todos os pedidos feitos
        System.out.println("Total de todos os pedidos: R$" + restaurante.calcularTotalDeTodosPedidos());

        scanner.close(); // Fechar o scanner
    }
}
