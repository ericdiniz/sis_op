import java.util.LinkedList;
import java.util.List;

public class Robo {
	public Robo() {
		
	}

	//empacotar
	//se o volume do pacote couber mais um produto, adiciona ele no pacote
	public static boolean adicionaNoPacote(List<Produto> pacote, Produto produto, int MAX_VOLUME_PACOTE) {
		int soma = 0;
		for (int i = 0; i < pacote.size(); i++) {
			soma += pacote.get(i).getVolumePorProduto();
		}
		if (soma + produto.getVolumePorProduto() < MAX_VOLUME_PACOTE) {
			pacote.add(produto);
			System.out.println("Produto de "+ produto.getFornecedor() +" empacotado!");
			return true;
		}
		return false;
	}

	public List<Produto> colocaNaEsteira(String fornecedor, List<Produto> pacote) {
		// pega um pacote vazio e coloca na esteira;
		pacote = new LinkedList<Produto>();
		System.out.println("Pacote colocado na esteira");
		return pacote;
	}
	
}
