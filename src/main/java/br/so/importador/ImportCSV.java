package br.so.importador;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.so.entity.Cliente;
import br.so.entity.Pedido;

public class ImportCSV {

	public static List<Pedido> readArqCSV(String file) {

		try {

			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReaderBuilder(filereader)
					.withCSVParser(new CSVParserBuilder().withSeparator(';').build()).withSkipLines(1).build();
			String[] nextRecord;
			int cont = 0;

			List<Pedido> pedidos = new ArrayList<>();

			while ((nextRecord = csvReader.readNext()) != null) {

				Pedido p = new Pedido();

				p.setCliente(new Cliente(nextRecord[0]));
				p.setQuantProdutos(Integer.valueOf(nextRecord[1]));
				p.setPrazoEmpc(Integer.valueOf(nextRecord[2]));

				pedidos.add(p);

				cont++;
			}

			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

}
