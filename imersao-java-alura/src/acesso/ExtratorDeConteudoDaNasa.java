package acesso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Conteudo;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

	public List<Conteudo> extraiConteudos(String json) {

		// extrai os dados do Json
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);

		List<Conteudo> conteudos = new ArrayList<>();

		// popular a lista de conteudos
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("url");
			Conteudo conteudo = new Conteudo(titulo, urlImagem);
			conteudos.add(conteudo);

		}

		return conteudos;

	}

}
