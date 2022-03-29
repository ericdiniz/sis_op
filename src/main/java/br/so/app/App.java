package br.so.app;

import java.util.List;

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

      pedidos.stream().sorted().forEach(p -> System.out.println(p.toString()));
      
    }
}
