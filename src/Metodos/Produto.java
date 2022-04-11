
public class Produto  implements Comparable<Produto>{

	private String fornecedor;
	private int totalProdutos;
	private int volumePorProduto;
	private int prazo;

	public Produto() {

	}

	public Produto(String fornecedor, int totalProdutos, int volumePorProduto, int prazo) {
		this.fornecedor = fornecedor;
		this.totalProdutos = totalProdutos;
		this.volumePorProduto = volumePorProduto;
		this.prazo = prazo;
	}

	//converte cada linha do CSV em um novo  produto
	public static Produto converterLinhaCSVEmProduto(String linha, String separador) {
		String[] partes = linha.split(separador);
		if(partes.length != 4) {
			throw new IllegalArgumentException("Linha de produto está incorreta: " + linha);
		}
		try {
			return new Produto(partes[0].trim(), Integer.parseInt(partes[1].trim()), Integer.parseInt(partes[2].trim()), Integer.parseInt(partes[3].trim()));
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("Linha de produto está incorreta: "+ linha);
		}
	}
	
	@Override
	public int compareTo(Produto produto) {
		if(this.prazo < produto.getPrazo()) {
			return -1;
		}
		if (this.prazo > produto.getPrazo()) {
			return 1;
		}
		return 0;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(int totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public int getVolumePorProduto() {
		return volumePorProduto;
	}

	public void setVolumePorProduto(int volumePorProduto) {
		this.volumePorProduto = volumePorProduto;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

}
