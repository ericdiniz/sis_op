package br.so.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
     final double VOLUME_MAX_PAC = 5000.0; // Volume máximo de um pacote
     final double TEMPO_FIX = 5; // 5 segundos 
     final double TEMPO_TRANS_PROD = 0.5;
 

      List<Pedido> pedidos = ImportCSV.readArqCSV("teste.txt");
 
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

      tempoTotal = 0.0;

      Map<Cliente, List<Pedido>> map = pedidos.stream().collect(Collectors.groupingBy(Pedido::getCliente));

      for(Entry<Cliente, List<Pedido>> m : map.entrySet()){

        double quantProd = m.getValue().stream().mapToDouble(Pedido::getQuantProdutos).sum();
        double prazoEmpc = m.getValue().stream().filter(p -> p.getPrazoEmpc() != Integer.MAX_VALUE).mapToDouble(Pedido::getPrazoEmpc).sum();
        double volumeTotal = m.getValue().stream().mapToDouble(Pedido::getVolPed).sum();
        double quantPac =  Math.ceil(volumeTotal/VOLUME_MAX_PAC);
        double tempoEmpac = (quantPac * TEMPO_FIX) + (quantProd * TEMPO_TRANS_PROD);

        System.out.println("Cliente: " + m.getKey().getNome() + " | Quantidade de produtos: " + quantProd
        + " | Prazo de empacotamento: " 
        + (prazoEmpc == 0 ? "Sem Prazo" : prazoEmpc)  
        +  " | Volume Total Pedido: "  + volumeTotal
        + " | Número de pacotes: " + quantPac + " | Tempo de empacotamento: " + tempoEmpac);

        tempoTotal += tempoEmpac;

        System.out.println("Tempo total da estreira (segundos): " +  tempoTotal);
        System.out.println("");

      }

      System.out.println("Média por pedido (segundos): " + (tempoTotal / pedidos.size()));
      
      System.out.println("Fim Opção 2");

      System.out.println("Opção 3 - Duplicar Esteira: ");









    }
}
