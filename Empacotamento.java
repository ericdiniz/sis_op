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
        String array[] = new String[3]; 
        int j = 0;
        String[] rows = linha.split(";");
        for (String r : rows) {
            String[] cols = r.split(";");
            for (String c : cols) {
                array[j] = c;
                System.out.print(array[j] + "\n" );
                j++;
            }
        }
        // tem que terminar essa parte
        // pesquisar sobre o for each
        this.nome = array[0];
        this.pedidos = Integer.parseInt(array[1]);
        this.PrazoEmpc = Integer.parseInt(array[2]);
        for(int k = 0; k < 3; k++)
            array[k] = "";
        j = 0;    
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
    // metodo utilizado : QUICKSORT pq? pq ele é rapido, caso alguem achar um melhor
    // pode mudar.
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
                // quando o prazo for o mesmo, estou dando prioridade para quem tiver menor
                // pedido.
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
            Cliente cliente[] = new Cliente[numPedidos];

            for (int i = 1; i <= numPedidos + 1; i++) {
                String data = myReader.nextLine();
                cliente[i] = new Cliente();
                cliente[i].SepararString(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ocorrido.");
            e.printStackTrace();
        }

    }
}