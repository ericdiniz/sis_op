package br.so.entity;

public class Pedido implements Comparable<Pedido> {

    private Cliente cliente;
    private int quantProdutos;
    private int prazoEmpc;

    /**
     * @return the quantProdutos
     */
    public int getQuantProdutos() {
        return quantProdutos;
    }
    /**
     * @param quantProdutos the quantProdutos to set
     */
    public void setQuantProdutos(int quantProdutos) {
        this.quantProdutos = quantProdutos;
    }
    /**
     * @return the prazoEmpc
     */
    public int getPrazoEmpc() {
        return prazoEmpc;
    }
    /**
     * @param prazoEmpc the prazoEmpc to set
     */
    public void setPrazoEmpc(int prazoEmpc) {
        this.prazoEmpc = prazoEmpc;
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    
    @Override
    public String toString() {
    
        return "Cliente: " + this.cliente.getNome() + " | Quantidade de produtos: " + this.quantProdutos + " | Tempo de empacotamento: " + this.getPrazoEmpc();
    }

    @Override
    public int compareTo(Pedido o) {

        if (this.prazoEmpc < o.prazoEmpc) {
            return -1;
        }
        if (this.prazoEmpc > o.prazoEmpc) {
            return 1;
        }
        return 0;
    
    }

    // montar a esteira
    /*
        Regras: 
        - limite de volume
        - prazo empacotamento 
        - tempo fixo 5 seg
        - tempo diario de 8h (4h manha e 4h tarde)
        
    */


    
}
