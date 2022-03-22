import java.io.*;
import java.util.Scanner;
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

    public void separar(String linha)
    {
        System.out.println("entrei no separar"+linha);
    };

}
public class Empacotamento {

    public static void main(String[] args) {
        try {

            File myObj = new File("teste.txt");
            Scanner myReader = new Scanner(myObj);
            int numPedidos = 0;
            numPedidos = myReader.nextInt();
            System.out.println(numPedidos);

            //var cliente
            Cliente cliente[] = new Cliente[numPedidos];

            for (int i = 1; i <= numPedidos + 1; i++) {
                String data = myReader.nextLine();
                // data leva pra classe cliente
                cliente[i] = new Cliente(); 
                cliente[i].separar(data);
                // separa o codigo com ; e faz os trem
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
