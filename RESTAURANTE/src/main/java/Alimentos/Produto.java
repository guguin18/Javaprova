/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alimentos;

/**
 *
 * @author aluno.den
 */

public class Produto {
    private String nome;  // Nome do produto (ex: "Hambúrguer", "Refrigerante")
    private String tipo;  // Tipo do produto (ex: "Comida" ou "Bebida")
    private double preco; // Preço do produto

    // Construtor da classe Produto
    public Produto(String nome, String tipo, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    // Métodos para acessar os atributos
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    // Sobrescrita do método toString para exibir o produto de forma formatada
    @Override
    public String toString() {
        return nome + " (" + tipo + ") - R$" + preco;
    }
}
