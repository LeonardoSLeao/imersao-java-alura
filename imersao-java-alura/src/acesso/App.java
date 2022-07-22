package acesso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import model.Conteudo;
import stickers.GeradorDeStickers;

public class App {

	public static void main(String[] args) throws Exception {

		// IMDB
		//String url = "https://api.mocki.io/v2/549a5d8b";
		// ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

		// NASA
		// String url ="https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
		// ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		
		// Linguagens
		String url = "http://localhost:8080/linguagens";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDeLinguagens();

		// chamada HTTP
		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(url);

		// chama o extrator para obter a lista de conteudos
		List<Conteudo> conteudos = extrator.extraiConteudos(json);

		// chama o gerador de stickers
		GeradorDeStickers geradorDeStickers = new GeradorDeStickers();

		for (int i = 0; i < conteudos.size(); i++) {

			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
			String nomeArquivo = "stickers/" + conteudo.getTitulo() + ".png";

			String dadosImagem = geradorDeStickers.criaStickers(inputStream, nomeArquivo);

			System.out.println(conteudo.getTitulo());
			System.out.println("Dados de tamanho da imagem: " + dadosImagem);
			System.out.println("Imagem: " + conteudo.getUrlImage());
			System.out.println("************************");
			System.out.println();

		}
	}
}
