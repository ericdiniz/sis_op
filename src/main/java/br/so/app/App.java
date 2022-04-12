package br.so.app;

import java.util.ArrayList;
import java.util.List;

import br.so.entity.Cliente;
import br.so.entity.Pedido;
import br.so.importador.ImportCSV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      List<Pedido> pedidos = ImportCSV.readArqCSV("teste.txt");
      List<Cliente> clientes = new ArrayList<Cliente>();

      pedidos.sort(Pedido::compareTo);

      System.out.println("Opção 1 - Prioridade de prazo de entrega e quantidade de produtos");

      double tempoTotal = 0.0;
    
      for(Pedido p : pedidos) {

        System.out.println(p.toString());

        tempoTotal += p.getTempo();
        System.out.println("Tempo total da estreira (segundos): " +  tempoTotal);
        System.out.println("");

      }

      System.out.println("Média por pedido (segundos): " + (tempoTotal / pedidos.size()));

      System.out.println("Fim Opção 1");

      System.out.println("Opção 2 - Prioridade de prazo de entrega por cliente");

      




      System.out.println("Fim Opção 2");

      System.out.println("Opção 3 - Duplicar Esteira: ");









    }
}
