package br.so.app;


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

 public static final double VOLUME_MAX_PAC = 5000.0; // Volume máximo de um pacote
 public static final double TEMPO_FIX = 5; // 5 segundos 
 public static final double TEMPO_TRANS_PROD = 0.5;
 public static final double DIA_TRABALHO = 1440.00; // 4 horas de trabalho, quando sai a primeira van 
 

    public static void main( String[] args )
    {
     


      mapByCliente();




    }

    public static double  getMediaByPedido(){

      List<Pedido> pedidos = ImportCSV.readArqCSV("teste.txt");

      pedidos.sort(Pedido::compareTo);

      double tempoTotal = 0.0;
    
      for(Pedido p : pedidos) {

        tempoTotal += p.getTempo();
    
      }

     return (tempoTotal / pedidos.size());

    }

    /**
     * Estratégia de agrupar os pedidos por cliente. 
     */
    public static void mapByCliente(){

      List<Pedido> pedidos = ImportCSV.readArqCSV("teste.txt");

      double tempoTotal = 0.0;
      double tempoTotalEsteira1 = 0.0;
      double tempoTotalEsteira2 = 0.0;
      double numPedidosDia = 0;
      double diasTerminoProd = 0; // Variável responsável por verificar a quantidade de dias para concluir a produção
      int i = 0;

      Map<Cliente, List<Pedido>> map = pedidos.stream().collect(Collectors.groupingBy(Pedido::getCliente));

      for(Entry<Cliente, List<Pedido>> m : map.entrySet()){

        double quantProd = m.getValue().stream().mapToDouble(Pedido::getQuantProdutos).sum();
        double prazoEmpc = m.getValue().stream().filter(p -> p.getPrazoEmpc() != Integer.MAX_VALUE).mapToDouble(Pedido::getPrazoEmpc).sum();
        double volumeTotal = m.getValue().stream().mapToDouble(Pedido::getVolPed).sum();
        double quantPac =  Math.ceil(volumeTotal/VOLUME_MAX_PAC); //Quantidade de pacotes a serem gerados por cliente. 
        double tempoEmpac = (quantPac * TEMPO_FIX) + (quantProd * TEMPO_TRANS_PROD);

        System.out.println("Cliente: " + m.getKey().getNome() + " | Quantidade de produtos: " + quantProd
        + " | Prazo de empacotamento: " 
        + (prazoEmpc == 0 ? "Sem Prazo" : prazoEmpc)  
        +  " | Volume Total Pedido: "  + volumeTotal
        + " | Número de pacotes: " + quantPac + " | Tempo de empacotamento: " + tempoEmpac);

        

        //Sorteio os clientes e somo o tempo para atendimento do pedido para cada esteira. 
        if(i % 2 == 0){
          tempoTotalEsteira1 += tempoEmpac;
        } else {
          tempoTotalEsteira2 += tempoEmpac;
        }

        i++;

        tempoTotal += tempoEmpac;

        numPedidosDia += tempoEmpac;

        if(numPedidosDia >= DIA_TRABALHO){
          System.out.println("\n");
          System.out.println("\n");
          System.out.println("Saiu a van - Numero de pedidos atendidos: " + i);
          System.out.println("\n");
          System.out.println("\n");
          numPedidosDia = 0.0;
          diasTerminoProd ++;
          i = 0;
        }

      
        System.out.println("Tempo total da estreira (segundos): " +  tempoTotal);
        System.out.println("");

      }

      if(numPedidosDia < DIA_TRABALHO){
        System.out.println("\n");
          System.out.println("\n");
          System.out.println("Encerramento - Numero de pedidos atendidos: " + i);
          System.out.println("\n");
          System.out.println("\n");
        diasTerminoProd ++;
        i = 0;
      }

      System.out.println("Estratédia de atendimento por pedido (única esteira)");
      System.err.println("Média por pedido (segundos)" + getMediaByPedido());

      System.out.println("Estratégia de atendimento por cliente (Uma única esteira): ");
      System.out.println("Média por pedido (segundos) (Única esteira): " + (tempoTotal / pedidos.size()));

      System.out.println("Quantidade de pedidos atendidos: " + pedidos.size());
      System.out.println("Quantidade de dias para termino: " + diasTerminoProd);

      System.out.println("\n");

      System.out.println("Estratégia de atendimento por cliente (Duas esteiras): ");
      System.out.println("Média por pedido esteira 1 - (segundos): " + (tempoTotalEsteira1 / (pedidos.size()/2)));
      System.out.println("Média por pedido esteira 2 - (segundos): " + (tempoTotalEsteira2 / (pedidos.size()/2)));
      System.out.println("Quantidade de pedidos atendidos: " + pedidos.size());
      System.out.println("Quantidade de dias para termino: " + diasTerminoProd/2);


      

      
    }

}
