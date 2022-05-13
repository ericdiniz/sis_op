package br.so.app;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.so.entity.Cliente;
import br.so.entity.Esteira;
import br.so.entity.Pedido;
import br.so.importador.ImportCSV;

/**
 * Hello world!
 *
 */
public class App {

  public static final double VOLUME_MAX_PAC = 5000.0; // Volume máximo de um pacote
  public static final double TEMPO_FIX = 5; // 5 segundos
  public static final double TEMPO_TRANS_PROD = 0.5;
  public static final double DIA_TRABALHO = 1440.00; // 4 horas de trabalho, quando sai a primeira van

  public static void main(String[] args) {

    getMediaByPedido();
    mapByCliente();

  }

  // Método responsável por avaliar a hiótese de atendimento por pedido.
  public static void getMediaByPedido() {

    List<Pedido> pedidos = ImportCSV.readArqCSV("teste.txt");

    pedidos.sort(Pedido::compareTo);

    double tempoTotal = 0.0;

    for (Pedido p : pedidos) {

      tempoTotal += p.getTempo();

     //System.out.println(p.getCliente().toString() + p.toString()); // Print dos pedidos

    }

    System.out.println("Média por pedido (Hipótese de atendimento por pedido) : " + (tempoTotal / pedidos.size()));
    System.out.println("\n");
  }

  /**
   * Estratégia de agrupar os pedidos por cliente.
   */
  public static void mapByCliente() {

    List<Pedido> pedidos = ImportCSV.readArqCSV("teste.txt");

    Map<Cliente, List<Pedido>> map = pedidos.stream().collect(Collectors.groupingBy(Pedido::getCliente));

    Esteira esteira1 = new Esteira(map, "1");

    //Método que criar uma tread para a esteira 1
    esteira1.executaEsteira();

  }

}
