package util;

import java.util.Scanner;

public class TesteEnum {

	public static void main(String[] args) {

		System.out.println("Infomre o serviço de onde gostaria de gerar os stickers:");
		System.out.println("1 para IMDB ou 2 para NASA");
		Scanner in = new Scanner(System.in);
		ServicoEnum opcao = ServicoEnum();

		for (ServicoEnum valor : ServicoEnum.values()) {
			System.out.println("Valor: " + valor.getOpcao());
		}

	}

}
