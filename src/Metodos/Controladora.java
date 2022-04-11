import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SortingFocusTraversalPolicy;

public class Controladora {

	// Constantes
	static final int MAX_VOLUME_PACOTE = 5000;
	static final float TEMPO_PRODUCAO_PACOTE = 5;
	static final float TRANSICAO_PACOTE = 0.5F;
	static final float SEGUNDOS_TRABALHADOS_POR_DIA = 32400.0F;
	static final float SEGUNDOS_ATE_ENTREGA = 14400.0F;
	// FimConstantes

	// ---------------COLOQUE O CAMINHO PARA O ARQUIVO CSV
	// AQUI:---------------------
	static final String CAMINHO_ARQUIVO = "C:\Vinicius\\Desktop\\Sistemas Operacionais\\ProjetoEsteira\\src\\Main\\arquivoteste.csv";
	// -------------------------------------------------------------------------------

	// Variáveis
	static float tempoTotal;
	static Robo bracoMecanico = new Robo();
	static Esteira esteira = new Esteira();
	static List<Produto> pacote1, pacote2, pacote3;
	static boolean eVazio;
	// FimVariaveis

	// -----FUNÇÕES-----

	// lê os produtos do CSV, chama a função de conversao em produto e armazena
	// todos os produtos em uma List
	public static List<Produto> lerProdutos(String arquivo, String separador) throws IOException {
		return Files.readAllLines(new File(arquivo).toPath(), StandardCharsets.UTF_8).stream().skip(1)
				.map(p -> Produto.converterLinhaCSVEmProduto(p, separador)).collect(Collectors.toList());
	}

	// pega o total de produtos do arquivo
	public static int totalProdutos(List<Produto> produtos) {
		return produtos.stream().mapToInt(Produto::getTotalProdutos).sum();
	}

	// pega o total de prazos de todos os produtos;
	public static int totalTempo(List<Produto> produtos) {
		return produtos.stream().mapToInt(Produto::getPrazo).sum();
	}

	// -----FIM-FUNÇÕES-----

	// -----ALGORITMOS-----

	public static void ShortestJobFirst(List<Produto> produtos) {
		List<Produto> produtos1 = new LinkedList<Produto>();
		Collections.sort(produtos);
		/*for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getPrazo() == 0) {
				produtos1.add(produtos.get(i));
				produtos.remove(i);
			}
		}*/
		pacote1 = new LinkedList<Produto>();
		pacote2 = new LinkedList<Produto>();
		loopSJFPrioridade(produtos);
		loopSJFEmZero(produtos);
		System.out.println("Tempo total da execução do SJF: " + tempoTotal);
	}

	public void RoundRobin() {

	}

	public static void loopSJFEmZero(List<Produto> produtos) {
		int prazo = 0;
		boolean verifica = true;
		for (int i = 0; i < produtos.size(); i++) {
			
			prazo = produtos.get(i).getPrazo();
			//System.out.println("prazo"+prazo);
			
			pacote2.removeAll(pacote2);
			//tempoTotal += TRANSICAO_PACOTE;
			if (prazo == 0) {
				bracoMecanico.colocaNaEsteira(produtos.get(i).getFornecedor(), pacote2);
				while (produtos.get(i).getTotalProdutos() != 0) {
					
					verifica = bracoMecanico.adicionaNoPacote(pacote2, produtos.get(i), MAX_VOLUME_PACOTE);
					if (verifica == false) {
						pacote2.removeAll(pacote2);
						bracoMecanico.colocaNaEsteira(produtos.get(i).getFornecedor(), pacote2);
						esteira.porNaCaixa(produtos, i);
						tempoTotal += TRANSICAO_PACOTE;
					} else {
						produtos.get(i).setTotalProdutos(produtos.get(i).getTotalProdutos() - 1);
						tempoTotal += TEMPO_PRODUCAO_PACOTE;
					}
					if (produtos.get(i).getTotalProdutos() == 0) {
						System.out.println("\n\nTodos os produtos de " + produtos.get(i).getFornecedor() + " foram empacotados.\n\n");
					}
				}
			} 
		}
	}
	
	public static void loopSJFPrioridade(List<Produto> produtos) {
		int prazo = 0;
		boolean verifica = true;
		for (int i = 0; i < produtos.size(); i++) {
			prazo = produtos.get(i).getPrazo();
			//System.out.println("prazp1"+prazo);
			pacote1.removeAll(pacote1);
			bracoMecanico.colocaNaEsteira(produtos.get(i).getFornecedor(), pacote1);
			tempoTotal += TRANSICAO_PACOTE;
			if (prazo != 0) {
				while (produtos.get(i).getTotalProdutos() != 0) {
					verifica = bracoMecanico.adicionaNoPacote(pacote1, produtos.get(i), MAX_VOLUME_PACOTE);
					if (verifica == false) {
						pacote1.removeAll(pacote1);
						bracoMecanico.colocaNaEsteira(produtos.get(i).getFornecedor(), pacote1);
						esteira.porNaCaixa(produtos, i);
						tempoTotal += TRANSICAO_PACOTE;
					} else {
						produtos.get(i).setTotalProdutos(produtos.get(i).getTotalProdutos() - 1);
						tempoTotal += TEMPO_PRODUCAO_PACOTE;
					}
					if (produtos.get(i).getTotalProdutos() == 0) {
						System.out.println("Todos os produtos de " + produtos.get(i).getFornecedor() + " foram empacotados.");
					}
				}
			} 
		}
	}

	public static void main(String[] args) throws IOException {
		List<Produto> produtosConvertidosDoCSV = lerProdutos(CAMINHO_ARQUIVO, ";");
		ShortestJobFirst(produtosConvertidosDoCSV);
	}
}

