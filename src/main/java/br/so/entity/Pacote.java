package br.so.entity;

import java.util.List;

public class Pacote {
    
    private long id; 
    private double volume; 
    private List<Produto> produtos;
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the volume
     */
    public double getVolume() {
        return volume;
    }
    /**
     * @param volume the volume to set
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }
    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }
    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
}
