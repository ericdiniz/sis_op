package br.so.entity;

public class ProdutoX extends Produto {
    

    private long identificador;
    private String desc;
    /**
     * @return the identificador
     */
    public long getIdentificador() {
        return identificador;
    }
    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    

}
