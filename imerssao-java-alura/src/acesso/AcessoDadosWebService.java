package acesso;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import stickers.GeradorDeStickers;

public class AcessoDadosWebService {

	public static void main(String[] args) throws Exception {

		// fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://api.mocki.io/v2/549a5d8b";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		// extrair só os dados que interessam (titulo, poster, classificação)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		// exibir os dados

		GeradorDeStickers geradorDeStickers = new GeradorDeStickers();

		for (Map<String, String> filme : listaDeFilmes) {

			String urlImagem = filme.get("image");
			String titulo = filme.get("title"); //

			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = "stickers/" + titulo + ".png";

			String dadosImagem = geradorDeStickers.criaStickers(inputStream, nomeArquivo);

			System.out.println(titulo);
			System.out.println("Dados da imagem: " + dadosImagem);
			System.out.println("Imagem: " + filme.get("image"));
			System.out.println("***********************");
			System.out.println();

			/*
			 * System.out.println("Título: " + filme.get("title"));
			 * System.out.println("Imagem: " + filme.get("image"));
			 * System.out.println("Classificação: " + filme.get("imDbRating"));
			 * System.out.println("Ano de Lançamento: " + filme.get("year"));
			 * System.out.println("***********************"); System.out.println();
			 */

		}
	}
}
