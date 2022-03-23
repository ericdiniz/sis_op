import java.io.*;
import java.util.Scanner;

class Cliente {

    // variaveis
    private String nome;
    private int NumCad; // numero de cadastros
    private int TotPed; // total de pedidos
    private int PrazoEmpc; // prazo de empacotamento
    private int pedidos; // pedidos

    // Construtores
    // vazio
    Cliente() {
    }

    // cheio
    Cliente(String nome, int NumCad, int TotPed, int PrazoEmpc, int pedidos) {
        this.nome = nome;
        this.NumCad = NumCad;
        this.TotPed = TotPed;
        this.PrazoEmpc = PrazoEmpc;
        this.pedidos = pedidos;
    }

    // get and set
    // nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // NumCad
    public void setNumCad(int NumCad) {
        this.NumCad = NumCad;
    }

    public int getNumCad() {
        return NumCad;
    }

    // TotPed
    public void setTotPed(int TotPed) {
        this.TotPed = TotPed;
    }

    public int getTotPed() {
        return TotPed;
    }

    // PrazoEmpc
    public void setPrazoEmpc(int PrazoEmpc) {
        this.PrazoEmpc = PrazoEmpc;
    }

    public int getPrazoEmpc() {
        return PrazoEmpc;
    }

    // PrazoEmpc
    public void setpedidos(int pedidos) {
        this.pedidos = pedidos;
    }

    public int getPedidos() {
        return pedidos;
    }

    // imprimir
    public void imprimir() {
        System.out.println(nome + " " + NumCad + " " + TotPed + " " + PrazoEmpc + " " + pedidos);
    }

    // receber a linha do main e inserir no objeto cliente
    public void SepararString(String linha) {
        // NAO FUNCIONA
        System.out.println(linha);

        // não estou conseguindo separar a string em 3 partes;
        // Está dando o seguinte erro:
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 
        Index 1 out of bounds for length 1
	    at Cliente.separar(Empacotamento.java:76)
	    at Empacotamento.main(Empacotamento.java:107)
        */
        /* Se alguem souber consertar pode deixar o codigo antigo e fazer um novo
        quero ver onde foi o erro!
        */

        
        String[] parts = linha.split(";");
        // ainda nao funciona, isso é um adiantamento do código
        String name = parts[0]; // nome
        String ped = parts[1]; // pedidos
        String prazo = parts[2]; // prazo

        // for(int i = 0; i < 3; i++)
        // System.out.println(sublinhas[i]);

        // Colocando as substrings no cliente
        this.nome = name;
        this.pedidos = Integer.parseInt(ped);
        this.PrazoEmpc = Integer.parseInt(prazo);

    }

}

class Fila {
    // variaveis
    private Cliente[] array;
    private int primeiro;
    private int ultimo;

    // construtores
    public Fila() {
        this(100);
    }

    public Fila(int tam) {
        array = new Cliente[tam + 1];
        primeiro = ultimo = 0;
    }

    // inserir Cliente na fila
    public void inserir(Cliente c) throws Exception {
        if (((ultimo + 1) % array.length) == primeiro) {
            throw new Exception("Erro ao inserir!");
        }

        array[ultimo] = c;
        ultimo = (ultimo + 1) % array.length;
    }

    // remover cliente da fila

    // ver qual cliente tem prioridade na fila, colocando eles em ordem
    // metodo utilizado : QUICKSORT  pq? pq ele é rapido, caso alguem achar um melhor pode mudar.
    public void quicksort(int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(inicio, fim);
            quicksort(inicio, posicaoPivo - 1);
            quicksort(posicaoPivo + 1, fim);
        }
    }
    public int separar(int inicio, int fim) {
        Cliente pivo = array[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (array[i].getPrazoEmpc() < pivo.getPrazoEmpc()) {
                i++;
            } else if (pivo.getPrazoEmpc() < array[f].getPrazoEmpc()) {
                f--;
                // quando o prazo for o mesmo, estou dando prioridade para quem tiver menor pedido.
            } else if (array[i].getPrazoEmpc() == pivo.getPrazoEmpc()
                    && array[i].getPedidos() < pivo.getPedidos()) {
                i++;
                // mesma coisa
            } else if (array[f].getPrazoEmpc() == pivo.getPrazoEmpc()
                    && pivo.getPedidos() < array[f].getPedidos()) {
                f--;
                // swap
            } else {
                Cliente troca = array[i];
                array[i] = array[f];
                array[f] = troca;
                i++;
                f--;
            }
        }
        array[inicio] = array[f];
        array[f] = pivo;
        return f;
    }

}

public class Empacotamento {

    public static void main(String[] args) {
        try {

            File myObj = new File("teste.txt");
            Scanner myReader = new Scanner(myObj);
            int numPedidos = 0;
            numPedidos = myReader.nextInt();

            // var cliente
            Cliente cliente = new Cliente();

            for (int i = 1; i <= numPedidos + 1; i++) {
                String data = myReader.nextLine();
                // data leva pra classe cliente
                // cliente[i] = new Cliente();
                System.out.println(data);
                // até aqui tudo funciona!
                cliente.SepararString(data);
                // separa o codigo com ; e faz os trem
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
