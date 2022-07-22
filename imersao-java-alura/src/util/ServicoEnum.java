package util;

public enum ServicoEnum {

	IMDB(1), NASA(2);

	private final int opcao;

	ServicoEnum(int opcao) {
		this.opcao = opcao;
	}

	public int getOpcao() {
		return this.opcao;
	}

}
