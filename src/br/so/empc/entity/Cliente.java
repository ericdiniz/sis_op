package src.br.so.empc.entity;

import java.util.List;

public class Cliente {
    
    private String nome;
    private String cpfCnpj;
    private int prazoEmpc;
    private List<Pedido> pedidos;
    
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
    /**
     * @return the cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    /**
     * @param cpfCnpj the cpfCnpj to set
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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
     * @return the pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    

}
