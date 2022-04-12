package br.so.entity;

import java.util.List;

public class Cliente {
    
    private String nome;
    private List<Pedido> pedidos;
    
    
    public Cliente() {
    }
    /**
     * @param nome
     */
    public Cliente(String nome) {
        this.nome = nome;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    





    
}
