
import java.util.List;
public class Esteira {
	public Esteira() {
		
	}
	
	public void porNaCaixa(List<Produto> pacote, int indice) {
		if(pacote.size() == 0) {
			System.out.println("Pacote vazio");
		} else {
			System.out.println("Colocou o pacote de "+ pacote.get(indice).getFornecedor() +" na caixa");
			//pacote.removeAll(pacote);
		}
	}
}
