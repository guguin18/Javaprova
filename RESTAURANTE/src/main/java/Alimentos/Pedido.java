/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alimentos;

/**
 *
 * @author aluno.den
 */

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int id; // ID único do pedido
    private final List<Produto> produtos; // Lista de produtos no pedido

    // Construtor da classe Pedido
    public Pedido(int id) {
        this.id = id;
        this.produtos = new ArrayList<>();
    }

    // Método para obter o ID do pedido
    public int getId() {
        return id;
    }

    // Método para adicionar um produto ao pedido
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para calcular o valor total do pedido
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    // Método para exibir todos os itens do pedido e o valor total
    public void exibirPedido() {
        System.out.println("Pedido ID: " + id);
        for (Produto produto : produtos) {
            System.out.println(produto); // Exibe cada produto usando o método toString()
        }
        System.out.println("Total: R$" + calcularTotal());
        System.out.println("--------------------");
    }
}
