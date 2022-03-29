package src.br.so.empc.app;
import java.io.*;

class Cliente{

    // variaveis
    private String nome;
    private int NumCad; //numero de cadastros
    private int TotPed; // total de pedidos
    private int PrazoEmpc; // prazo de empacotamento
    private int pedidos; // pedidos

    // Construtores
    // vazio
    Cliente(){
    }
    // cheio
    Cliente(String nome, int NumCad, int TotPed, int PrazoEmpc, int pedidos){
        this.nome = nome;
        this.NumCad = NumCad;
        this.TotPed = TotPed;
        this.PrazoEmpc = PrazoEmpc;
        this.pedidos = pedidos;
    }

    // get and set
    // nome
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    // NumCad
    public void setNumCad(int NumCad){
        this.NumCad = NumCad;
    }
    public int getNumCad(){
        return NumCad;
    }
    // TotPed
    public void setTotPed(int TotPed){
        this.TotPed = TotPed;
    }
    public int getTotPed(){
        return TotPed;
    }
    // PrazoEmpc
    public void setPrazoEmpc(int PrazoEmpc){
        this.PrazoEmpc = PrazoEmpc;
    }
    public int getPrazoEmpc(){
        return PrazoEmpc;
    }
    // PrazoEmpc
    public void setpedidos(int pedidos){
        this.pedidos = pedidos;
    }
    public int getPedidos(){
        return pedidos;
    }

    // imprimir
    public void imprimir()
    {
        System.out.println(nome + " " + NumCad + " " + TotPed + " " + PrazoEmpc + " " + pedidos);
    }
}
class Pedidos{
    private int pedidos;

    Pedidos(){
    }
    Pedidos(int pedidos){
        this.pedidos = pedidos;
    }

    public void setPedidos(int pedidos){
        this.pedidos = pedidos;
    }
    public int getPedidos(){
        return pedidos;
    }

    public void imprimir()
    {
        System.out.println(pedidos);
    }
}
class Pacotes{
    private Double Volume;
    private String produto;

    Pacotes(){}
    Pacotes(double volume, String produto){
        this.Volume = volume;
        this.produto = produto;
    }

    public void setVolume(Double Volume){
        this.Volume = Volume;
    }
    public Double getVolume(){
        return Volume;
    }

    public void imprimir()
    {
        System.out.println(Volume + " " + produto);
    }
}
public class Teste {
 public static void main(String[] args) {
        

 }   
}
