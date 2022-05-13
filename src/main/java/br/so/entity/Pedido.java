package br.so.entity;

import java.util.Comparator;

public class Pedido implements Comparable<Pedido> {

    private Cliente cliente;
    private double quantProdutos;
    private double prazoEmpc;
    private static final double VOLUME_PROD = 250.0; // Volume da unidade de produto 
    private static final double VOLUME_MAX_PAC = 5000.0; // Volume máximo de um pacote
    private static final double TEMPO_FIX = 5; // 5 segundos 
    private static final double TEMPO_TRANS_PROD = 0.5;

    

    /**
     * @return the quantProdutos
     */
    public double getQuantProdutos() {
        return quantProdutos;
    }

    /**
     * @param quantProdutos the quantProdutos to set
     */
    public void setQuantProdutos(double quantProdutos) {
        this.quantProdutos = quantProdutos;
    }

    /**
     * @return the prazoEmpc
     */
    public double getPrazoEmpc() {

        if(prazoEmpc == 0)
            return Integer.MAX_VALUE;

        return prazoEmpc;
    }

    /**
     * @param prazoEmpc the prazoEmpc to set
     */
    public void setPrazoEmpc(double prazoEmpc) {
        this.prazoEmpc = prazoEmpc;
    }

    /**
     * 
     * @return Retorna o tempo de empacotamento. 
     */
    public double getTempo() {
        return (this.getQuantPac() * TEMPO_FIX) + (this.getQuantProdutos() * TEMPO_TRANS_PROD);
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * 
     * @return Retorna a quantidade de pacotes que serão gerados nesse pedido. 
     */
    public double getQuantPac(){
        return Math.ceil(getVolPed() / VOLUME_MAX_PAC);
    }

    /**
     * 
     * @return Retorna o volume total dos produtos do pedido em questão. 
     */
    public double getVolPed(){
        return this.getQuantProdutos() * VOLUME_PROD;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {

        return  "| Quantidade de produtos: " + this.quantProdutos
                + " | Prazo de empacotamento: " 
                + (this.getPrazoEmpc() == Integer.MAX_VALUE ? "Sem Prazo" : this.getPrazoEmpc())  
                +  " | Volume Total Pedido: "  + this.getVolPed() 
                + " | Número de pacotes: " + this.getQuantPac() + " | Tempo de empacotamento: " + this.getTempo();
    }

    @Override
    public int compareTo(Pedido o) {

        return Comparator
        .comparing(Pedido::getPrazoEmpc)
        .thenComparing(Pedido::getQuantProdutos)
        .compare(this, o);

    }

}
