package br.so.entity;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Esteira {

    public static final double DIA_TRABALHO = 1440.00; // 4 horas de trabalho, quando sai a primeira van 

    public Esteira(Map<Cliente, List<Pedido>> pedidos, String idEsteira) {
        this.pedidos = pedidos;
        this.idEsteira = idEsteira;
    }

    private Map<Cliente, List<Pedido>> pedidos;

    private String idEsteira;

    /**
     * Instancia uma tread para rolar a esteira. 
     */
    public void executaEsteira() {

        new Thread() {

            @Override
            public void run() {

                double tempoTotal = 0.0; // Computa o tempo total da esteira. 
                double count = 0.0;
                double diasTerminoProd = 0; // Variável responsável por verificar a quantidade de dias para concluir a produção
                double numPedidosDia = 0;

                for (Entry<Cliente, List<Pedido>> m : getPedidos().entrySet()) {

                  Pedido p = agrupaPedidos(m.getValue());

                  count += m.getValue().size();

                  tempoTotal += p.getTempo();

                  //System.out.println(m.getKey().toString() + p.toString()); // Print dos pedidos
                
                  numPedidosDia += p.getTempo();

                  if(numPedidosDia >= DIA_TRABALHO){
                    numPedidosDia = 0.0;
                    diasTerminoProd ++;
                  }
                }

                System.out.println("\nTempo Total da esteira de ID: " + getIdEsteira() + " (segundos): " +  tempoTotal);

                System.out.println("\nMédia por pedido da esteira: "  + getIdEsteira() + " | "+  (tempoTotal/count));
                
                System.out.println("\nQuantidade de pedidos atendidos: " +  count);
                System.out.println("\nDias para o término da produção: " +  diasTerminoProd);

            }

        }.start();
    }

 
    /**
     * Método responsável por pegar os pedidos de um determinado cliente e agrupalos
     * em um só.
     * 
     * @param pedidos Pedidos de um mesmo cliente
     * @return Retorna um pedido agrupado.
     */
    private Pedido agrupaPedidos(List<Pedido> pedidos) {

        Pedido p = new Pedido();

        double quantProd = pedidos.stream().mapToDouble(Pedido::getQuantProdutos).sum();
        double prazoEmpc = pedidos.stream().filter(pe -> pe.getPrazoEmpc() != Integer.MAX_VALUE)
                .mapToDouble(Pedido::getPrazoEmpc).sum();

        p.setQuantProdutos(quantProd);
        p.setPrazoEmpc(prazoEmpc);

        return p;
    }

    public String getIdEsteira() {
        return idEsteira;
    }

    public void setIdEsteira(String idEsteira) {
        this.idEsteira = idEsteira;
    }

    public Map<Cliente, List<Pedido>> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Map<Cliente, List<Pedido>> pedidos) {
        this.pedidos = pedidos;
    }

}
