import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundRobinTest {
	static int i1 = 0, i2 = 0, i3 = 0;
	static final String CAMINHO_ARQUIVO = "C:\Vinicius\\Desktop\\Sistemas Operacionais\\ProjetoEsteira\\src\\Main\\arquivoteste.csv";
	static final int MAX_VOLUME_PACOTE = 5000;
	static Robo bracoMecanico = new Robo();
	static double totalVolume = 0;
	static List<Produto> pacote1 = new ArrayList<Produto>();
	static List<Produto> pacote2 = new ArrayList<Produto>();
	static List<Produto> pacote3 = new ArrayList<Produto>();

	public static ArrayList<Produto> lerProdutos(String arquivo, String separador) throws IOException {
		return (ArrayList<Produto>) Files.readAllLines(new File(arquivo).toPath(), StandardCharsets.UTF_8).stream()
				.skip(1).map(p -> Produto.converterLinhaCSVEmProduto(p, separador)).collect(Collectors.toList());
	}

	public static void RoundRobin() throws IOException {

		ArrayList<Produto> produtosConvertidosDoCSV = lerProdutos(CAMINHO_ARQUIVO, ";");
		ArrayList<Produto> prioridade0 = new ArrayList<Produto>();
		ArrayList<Produto> aux = new ArrayList<Produto>();
		Produto p = new Produto();
		Collections.sort(produtosConvertidosDoCSV);
		for (int i = 0; i < produtosConvertidosDoCSV.size(); i++) {
			if (produtosConvertidosDoCSV.get(i).getPrazo() == 0) {
				prioridade0.add(produtosConvertidosDoCSV.get(i));
				System.out.println("prazooo: "+produtosConvertidosDoCSV.get(i).getPrazo());
				produtosConvertidosDoCSV.remove(i);

			}
		}
		/*
		 * for (int i1 = 0; i1 < produtosConvertidosDoCSV.size(); i1++) { p =
		 * produtosConvertidosDoCSV.get(i1); totalVolume = p.getVolumePorProduto() *
		 * p.getTotalProdutos(); double resto = 0; double quant = 0; if (totalVolume <
		 * MAX_VOLUME_PACOTE) { if (p.getPrazo() != 0)
		 * bracoMecanico.adicionaNoPacoteRR(pacote1, produtosConvertidosDoCSV.get(i1));
		 * } if (totalVolume > MAX_VOLUME_PACOTE) { resto = totalVolume -
		 * MAX_VOLUME_PACOTE; quant = resto / p.getVolumePorProduto();
		 * p.setTotalProdutos((int) quant); if (p.getPrazo() != 0) {
		 * System.out.println("PASEEI AQUI 1"); aux.add(p);
		 * bracoMecanico.adicionaNoPacoteRR(pacote1, produtosConvertidosDoCSV.get(i1));
		 * } } }
		 * 
		 * // System.out.println(aux.toString()); for (int i2 = 0; i2 < aux.size();
		 * i2++) { p = aux.get(i2); totalVolume = p.getVolumePorProduto() *
		 * p.getTotalProdutos(); double resto2 = 0; double quant2 = 0; if (totalVolume >
		 * MAX_VOLUME_PACOTE) { System.out.println("PASEEI AQUI 2"); resto2 =
		 * totalVolume - MAX_VOLUME_PACOTE; quant2 = resto2 / p.getVolumePorProduto();
		 * p.setTotalProdutos((int) quant2); aux.add(p);
		 * bracoMecanico.adicionaNoPacoteRR(pacote2, aux.get(i2)); } } for (int i3 = 0;
		 * i3 < prioridade0.size(); i3++) { p = prioridade0.get(i3); totalVolume =
		 * p.getVolumePorProduto() * p.getTotalProdutos(); double resto = 0; double
		 * quant = 0; if (totalVolume > MAX_VOLUME_PACOTE) {
		 * System.out.println("PASEEI AQUI 3"); resto = totalVolume - MAX_VOLUME_PACOTE;
		 * quant = resto / p.getVolumePorProduto(); p.setTotalProdutos((int) quant);
		 * aux.add(p); bracoMecanico.adicionaNoPacoteRR(pacote3, prioridade0.get(i3)); }
		 * }
		 */
		/*int j = 0;
		float qtde;
		boolean verifica = true;
		Esteira esteira = new Esteira();
		for (int i = 0; i < produtosConvertidosDoCSV.size(); i++) {
			System.out.println("entrei no primeiro loop");
			if (produtosConvertidosDoCSV.get(i).getTotalProdutos()
					* produtosConvertidosDoCSV.get(i).getVolumePorProduto() > MAX_VOLUME_PACOTE) {
				System.out.println("passei no max");
				qtde = produtosConvertidosDoCSV.get(i).getTotalProdutos()
						* produtosConvertidosDoCSV.get(i).getVolumePorProduto() / MAX_VOLUME_PACOTE;
				System.out.println("qtde        " + qtde);
				while (j <= qtde) {
					System.out.println("passei na quantidade. prazo:" + produtosConvertidosDoCSV.get(i).getPrazo());
					
					if (produtosConvertidosDoCSV.get(i).getPrazo() != 0)
						verifica = bracoMecanico.adicionaNoPacote(pacote1, produtosConvertidosDoCSV.get(i),
								MAX_VOLUME_PACOTE);
					if (verifica == false) {
						System.out.println("passei no verifica j:" + j);
						esteira.porNaCaixaRR(produtosConvertidosDoCSV.get(i));
						pacote1.removeAll(pacote1);
						bracoMecanico.colocaNaEsteira(produtosConvertidosDoCSV.get(i).getFornecedor(), pacote1);
						j++;
						if (j == qtde) {
							System.out.println("passei no quanitdade");
							j = 0;
							break;
						}
					}
				}
			}
		}*/

	}

	public static void main(String[] args) throws IOException {

		RoundRobin();

	}
}
