package br.so.entity;

public class Cliente {
    
    private String nome;
    
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

    
}
